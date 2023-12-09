package reservations_testing;

import driver.Booking;
import driver.BookingCatalog;
import driver.Guest;
import driver.Room;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookingCatalogTesting {


	@Test
    public void testCreateBookingWithDetails() throws IOException {
		BookingCatalog catalog = new BookingCatalog();
		Room room = new Room("52", false, "queen", 2, "comfort", 100);
		Guest guest = new Guest();
		guest.setUserName("nick@baylor.edu");
		LocalDate startDate = LocalDate.of(2024, 1, 12);
		LocalDate endDate = LocalDate.of(2024, 2, 12);
		long daysBetween = Math.abs(endDate.until(startDate, ChronoUnit.DAYS));
		long totalRate = room.getRate() * daysBetween;
		
		catalog.createBooking(room, startDate, endDate, guest, totalRate);
		ArrayList<Booking> bookings = catalog.getGuestBookings(guest);
		
		assertEquals(guest, bookings.get(0).getGuest());
	}

	@Test
	public void testCreateBookingWithBookings() throws IOException {
		BookingCatalog catalog = new BookingCatalog();
		Room room = new Room("52", false, "queen", 2, "comfort", 100);
		Guest guest = new Guest();
		guest.setUserName("nick@baylor.edu");
		LocalDate startDate = LocalDate.of(2024, 1, 12);
		LocalDate endDate = LocalDate.of(2024, 2, 12);
		long daysBetween = Math.abs(endDate.until(startDate, ChronoUnit.DAYS));
		long totalRate = room.getRate() * daysBetween;

		Booking newBooking = new Booking(room, startDate, endDate, guest, totalRate);

		catalog.createBooking(newBooking);
		ArrayList<Booking> bookings = catalog.getGuestBookings(guest);

		assertTrue("Not True", bookings.size() == 1);
		//assertEquals(guest, bookings.get(0).getGuest());
	}

	@Test
    public void testGetAvailableRooms() throws IOException {
		BookingCatalog catalog = new BookingCatalog();
		ArrayList<Room> input_rooms = new ArrayList<Room>();

		Room room = new Room("52", false, "queen", 2, "comfort", 100);
		Guest guest = new Guest();
		guest.setUserName("nick@baylor.edu");

		input_rooms.add(room);

		LocalDate bookingStartDate = LocalDate.of(2023, 12, 23);
		LocalDate bookingEndDate = LocalDate.of(2023, 12, 25);
		long daysBetween = bookingStartDate.until(bookingEndDate, ChronoUnit.DAYS);
		long rate = Math.abs(room.getRate() * daysBetween);

		catalog.createBooking(room, bookingStartDate, bookingEndDate, guest, rate );
		
		LocalDate startDate = LocalDate.of(2024, 1, 12);
		LocalDate endDate = LocalDate.of(2024, 2, 12);
		
		ArrayList<Room> output_rooms = catalog.getAvailableRooms(input_rooms, startDate, endDate);
		
		assertEquals(input_rooms, output_rooms);
	}

	@Test
	public void testDeleteBooking() throws IOException {
		BookingCatalog catalog = new BookingCatalog();

		Room room = new Room("52", false, "queen", 2, "comfort", 100);

		Guest guest = new Guest();
		guest.setUserName("nick@baylor.edu");

		LocalDate bookingStartDate = LocalDate.of(2023, 12, 23);
		LocalDate bookingEndDate = LocalDate.of(2023, 12, 25);
		long daysBetween = bookingStartDate.until(bookingEndDate, ChronoUnit.DAYS);
		long rate = Math.abs(room.getRate() * daysBetween);

		Booking newBooking = new Booking(room, bookingStartDate, bookingEndDate, guest, rate);

		catalog.createBooking(newBooking);

		catalog.deleteBooking(newBooking);

		assertTrue("Booking did not delete", catalog.getGuestBookings(guest).isEmpty());
	}

	@Test
	public void testCancelBooking() throws IOException {
		BookingCatalog catalog = new BookingCatalog();

		Room room = new Room("52", false, "queen", 2, "comfort", 100);

		Guest guest = new Guest();
		guest.setUserName("nick@baylor.edu");

		LocalDate bookingStartDate = LocalDate.of(2023, 12, 23);
		LocalDate bookingEndDate = LocalDate.of(2023, 12, 25);
		long daysBetween = bookingStartDate.until(bookingEndDate, ChronoUnit.DAYS);
		long rate = Math.abs(room.getRate() * daysBetween);

		Booking newBooking = new Booking(room, bookingStartDate, bookingEndDate, guest, rate);

		catalog.createBooking(newBooking);

		catalog.cancelBooking(newBooking);

		Booking bookingToCheck = catalog.getBookings().get("52").getFirst();

		assertTrue("Booking did not cancel properly", bookingToCheck.getCanceledPaid());
	}

}
