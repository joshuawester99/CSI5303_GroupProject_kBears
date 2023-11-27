package reservations_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import driver.BookingCatalog;
import driver.Guest;
import driver.ReservationController;
import driver.Room;
import driver.RoomCatalog;
import driver.UserCatalog;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ReservationControllerTesting {

	static ReservationController controller;
	static BookingCatalog booking;
	static RoomCatalog rooms;
	static UserCatalog users;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
		booking = new BookingCatalog();
		rooms = new RoomCatalog();
		controller = new ReservationController(booking, rooms);
		users = new UserCatalog();
		
		rooms.createRoom("1", true, "Full", 2, "Comfort");
        rooms.createRoom("2", false, "Queen", 2, "Comfort");
        rooms.createRoom("3", true, "King", 1, "Comfort");
        rooms.createRoom("4", false, "Full", 2, "Comfort");
        rooms.createRoom("5", true, "Queen", 1, "Comfort");
        rooms.createRoom("6", false, "King", 2, "Executive");
        rooms.createRoom("7", true, "King", 2, "Executive");
        rooms.createRoom("8", false, "King", 2, "Executive");
        rooms.createRoom("9", true, "Full", 1, "Business");
        rooms.createRoom("10", false, "Full", 2, "Economy");
        rooms.createRoom("11", true, "Queen", 1, "Business");
        rooms.createRoom("12", false, "Twin", 2, "Economy");
        rooms.createRoom("13", true, "Queen", 1, "Executive");
        rooms.createRoom("14", false, "Twin", 2, "Comfort");
        rooms.createRoom("15", true, "Queen", 1, "Economy");
        rooms.createRoom("16", false, "Full", 2, "Executive");
        rooms.createRoom("17", false, "King", 1, "Business");
        rooms.createRoom("18", true, "Queen", 2, "Business");
        rooms.createRoom("19", false, "Queen", 1, "Eeconomy");
        rooms.createRoom("20", true, "Full", 1, "Economy");

        users.guestSignUp("nick", "nick@baylor.edu", "hi");
        users.guestSignUp("jaired", "jaired@baylor.edu", "hi");
        users.guestSignUp("joshua", "joshua@baylor.edu", "hi");
        users.clerkSignUp("George","george@hotel.com");
        
		for (int i = 1; i < 11; i++){
            booking.createBooking(rooms.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 11, 8), LocalDate.of(2023, 11, 13), (Guest) users.getUsers().get("nick@baylor.edu"));
        }
        for (int i = 11; i < 21; i++){
            booking.createBooking(rooms.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 11, 8), LocalDate.of(2023, 11, 13), (Guest) users.getUsers().get("jaired@baylor.edu"));
        }
        booking.createBooking(rooms.getRooms().get("4"), LocalDate.of(2023, 11, 17), LocalDate.of(2023, 11, 20), (Guest) users.getUsers().get("joshua@baylor.edu"));
        booking.createBooking(rooms.getRooms().get("5"), LocalDate.of(2023, 11, 17), LocalDate.of(2023, 11, 20), (Guest) users.getUsers().get("joshua@baylor.edu"));
        booking.createBooking(rooms.getRooms().get("6"), LocalDate.of(2023, 11, 17), LocalDate.of(2023, 11, 20), (Guest) users.getUsers().get("joshua@baylor.edu"));
        booking.createBooking(rooms.getRooms().get("7"), LocalDate.of(2023, 11, 24), LocalDate.of(2023, 11, 27), (Guest) users.getUsers().get("nick@baylor.edu"));
        booking.createBooking(rooms.getRooms().get("12"), LocalDate.of(2023, 11, 24), LocalDate.of(2023, 11, 28), (Guest) users.getUsers().get("nick@baylor.edu"));
	}
	
	@Test
	public void TestGetAvailableRooms_no_valid_rooms() {
		Boolean smoking = false;
		String bedType = "queen";
		int bedNumber = 2;
		String quality = "comfort";
		LocalDate startDate = LocalDate.of(2023,  11,  8);
		LocalDate endDate = LocalDate.of(2023, 12, 4);
		
		ArrayList<Room> room_list = controller.getAvailableRooms(smoking, bedType, bedNumber, quality, startDate, endDate);
		assertTrue("Fail: rooms is not empty", room_list.isEmpty());
	}
	
	@Test
	public void TestGetAvailableRooms_one_valid_room() {
		Boolean smoking = false;
		String bedType = "queen";
		int bedNumber = 2;
		String quality = "comfort";
		LocalDate startDate = LocalDate.of(2024,  12,  18);
		LocalDate endDate = LocalDate.of(2024, 12, 4);
		
		ArrayList<Room> room_list = controller.getAvailableRooms(smoking, bedType, bedNumber, quality, startDate, endDate);
		assertTrue("Fail: rooms is empty", !room_list.isEmpty());
	}

	@Disabled
	@Test
    void testMakeReservation() throws IOException {
        Guest guest = new Guest();

        String input = "true\nqueen\n2\ncomfort\n2023\n12\n8\n2023\n12\n20\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        controller.makeReservation(guest);

        assertEquals(guest, controller.getGuestBookings(guest).get(0).getGuest());
    }
	
	@Test
    void testSelectRoom (){
		
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        ArrayList<Room> all_rooms = controller.getAllRooms();
        
        assertEquals("5", controller.selectRoom(all_rooms).getRoomNumber());
    }
	
}
