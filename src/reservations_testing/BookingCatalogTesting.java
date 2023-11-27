package reservations_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import driver.BookingCatalog;
import driver.Room;
import driver.Guest;
import driver.Booking;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

class BookingCatalogTesting {

	@Test
	void testCreateBooking() throws IOException {
		BookingCatalog catalog = new BookingCatalog();
		Room room = new Room("52", false, "queen", 2, "comfort");
		Guest guest = new Guest();
		guest.setUserName("nick@baylor.edu");
		LocalDate startDate = LocalDate.of(2024, 1, 12);
		LocalDate endDate = LocalDate.of(2024, 2, 12);
		
		catalog.createBooking(room, startDate, endDate, guest);
		ArrayList<Booking> bookings = catalog.getGuestBookings(guest);
		
		assertEquals(guest, bookings.get(0).getGuest());
	}

	@Disabled
	@Test
	void testGetAvailableRooms() throws IOException {
		BookingCatalog catalog = new BookingCatalog();
		ArrayList<Room> input_rooms = new ArrayList<Room>();
		Room room = new Room("52", false, "queen", 2, "comfort");
		input_rooms.add(room);
		
		LocalDate startDate = LocalDate.of(2024, 1, 12);
		LocalDate endDate = LocalDate.of(2024, 2, 12);
		
		Guest guest = new Guest();
		guest.setUserName("nick@baylor.edu");
		
		ArrayList<Room> output_rooms = catalog.getAvailableRooms(input_rooms, startDate, endDate);
		
		assertEquals(input_rooms, output_rooms);
	}

}
