package reservations_testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import driver.BookingCatalog;
import driver.Guest;
import driver.ReservationController;
import driver.Room;
import driver.RoomCatalog;
import driver.UserCatalog;

import reservations_interface.CLI_Reservation;

class CLI_ReservationTesting {
	
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

        rooms.createRoom("1", true, "Full", 2, "Comfort", 150);
        rooms.createRoom("2", false, "Queen", 2, "Comfort", 150);
        rooms.createRoom("3", true, "King", 1, "Comfort", 120);
        rooms.createRoom("4", false, "Full", 2, "Comfort", 120);
        rooms.createRoom("5", true, "Queen", 1, "Comfort", 100);
        rooms.createRoom("6", false, "King", 2, "Executive", 400);
        rooms.createRoom("7", true, "King", 2, "Executive", 350);
        rooms.createRoom("8", false, "King", 2, "Executive", 350);
        rooms.createRoom("9", true, "Full", 1, "Business", 200);
        rooms.createRoom("10", false, "Full", 2, "Economy", 80);
        rooms.createRoom("11", true, "Queen", 1, "Business", 220);
        rooms.createRoom("12", false, "Twin", 2, "Economy", 100);
        rooms.createRoom("13", true, "Queen", 1, "Executive", 500);
        rooms.createRoom("14", false, "Twin", 2, "Comfort", 130);
        rooms.createRoom("15", true, "Queen", 1, "Economy", 90);
        rooms.createRoom("16", false, "Full", 2, "Executive", 550);
        rooms.createRoom("17", false, "King", 1, "Business", 250);
        rooms.createRoom("18", true, "Queen", 2, "Business", 210);
        rooms.createRoom("19", false, "Queen", 1, "Eeconomy", 100);
        rooms.createRoom("20", true, "Full", 1, "Economy", 110);


        users.guestSignUp("nick", "nick@baylor.edu", "hi", false, "12345678");
        users.guestSignUp("jaired", "jaired@baylor.edu", "hi", false, "87654321");
        users.guestSignUp("joshua", "joshua@baylor.edu", "hi", true, "Delta Air Lines");
        users.clerkSignUp("George","george@hotel.com");
        
		for (int i = 1; i < 11; i++){
            booking.createBooking(rooms.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 11, 8), LocalDate.of(2023, 11, 13), (Guest) users.getUsers().get("nick@baylor.edu"), rooms.getRooms().get(Integer.toString(i)).getRate() * LocalDate.of(2023, 11, 13).until(LocalDate.of(2023, 11, 8), ChronoUnit.DAYS));
        }
        for (int i = 11; i < 21; i++){
            booking.createBooking(rooms.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 11, 8), LocalDate.of(2023, 11, 13), (Guest) users.getUsers().get("jaired@baylor.edu"), rooms.getRooms().get(Integer.toString(i)).getRate() * LocalDate.of(2023, 11, 13).until(LocalDate.of(2023, 11, 8), ChronoUnit.DAYS));
        }
        booking.createBooking(rooms.getRooms().get("4"), LocalDate.of(2023, 11, 17), LocalDate.of(2023, 11, 20), (Guest) users.getUsers().get("joshua@baylor.edu"), rooms.getRooms().get("4").getRate() * LocalDate.of(2023, 11, 13).until(LocalDate.of(2023, 11, 8), ChronoUnit.DAYS));
        booking.createBooking(rooms.getRooms().get("5"), LocalDate.of(2023, 11, 17), LocalDate.of(2023, 11, 20), (Guest) users.getUsers().get("joshua@baylor.edu"), rooms.getRooms().get("5").getRate() * LocalDate.of(2023, 11, 13).until(LocalDate.of(2023, 11, 8), ChronoUnit.DAYS));
        booking.createBooking(rooms.getRooms().get("6"), LocalDate.of(2023, 11, 17), LocalDate.of(2023, 11, 20), (Guest) users.getUsers().get("joshua@baylor.edu"), rooms.getRooms().get("6").getRate() * LocalDate.of(2023, 11, 13).until(LocalDate.of(2023, 11, 8), ChronoUnit.DAYS));
        booking.createBooking(rooms.getRooms().get("7"), LocalDate.of(2023, 11, 24), LocalDate.of(2023, 11, 27), (Guest) users.getUsers().get("nick@baylor.edu"), rooms.getRooms().get("7").getRate() * LocalDate.of(2023, 11, 13).until(LocalDate.of(2023, 11, 8), ChronoUnit.DAYS));
        booking.createBooking(rooms.getRooms().get("12"), LocalDate.of(2023, 11, 24), LocalDate.of(2023, 11, 28), (Guest) users.getUsers().get("nick@baylor.edu"), rooms.getRooms().get("12").getRate() * LocalDate.of(2023, 11, 13).until(LocalDate.of(2023, 11, 8), ChronoUnit.DAYS));
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
