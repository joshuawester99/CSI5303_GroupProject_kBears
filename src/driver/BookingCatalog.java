package driver;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookingCatalog implements Serializable {

    private HashMap<String, ArrayList<Booking>> bookings = new HashMap<String, ArrayList<Booking>>();

    // Add booking to catalog with booking details
    public void createBooking(Room room, LocalDate startDate, LocalDate endDate, Guest guest, long totalRate) throws IOException {
        Booking booking = new Booking(room, startDate, endDate, guest, totalRate);

        if (bookings.get(room.getRoomNumber()) == null){
            ArrayList<Booking> newBookingList = new ArrayList<Booking>();
            newBookingList.add(booking);
            bookings.put(room.getRoomNumber(), newBookingList);
        } else {
            bookings.get(room.getRoomNumber()).add(booking);
        }

        saveBookingCatalog();
    }


    // Overload createBooking to add a booking to catalog with booking input
    public void createBooking (Booking booking) throws IOException {
        if (bookings.get(booking.getRoom().getRoomNumber()) == null){
            ArrayList<Booking> newBookingList = new ArrayList<Booking>();
            newBookingList.add(booking);
            bookings.put(booking.getRoom().getRoomNumber(), newBookingList);
        } else {
            bookings.get(booking.getRoom().getRoomNumber()).add(booking);
        }

        saveBookingCatalog();
    }

    // Overloaded createBooking for the ability to customize booking dates for system testing
    public void createBooking(Room room, LocalDate startDate, LocalDate endDate, Guest guest, long totalRate, LocalDate dateToPut) throws IOException {
        Booking booking = new Booking(room, startDate, endDate, guest, totalRate);
        booking.setBookingDate(dateToPut);

        if (bookings.get(room.getRoomNumber()) == null){
            ArrayList<Booking> newBookingList = new ArrayList<Booking>();
            newBookingList.add(booking);
            bookings.put(room.getRoomNumber(), newBookingList);
        } else {
            bookings.get(room.getRoomNumber()).add(booking);
        }

        saveBookingCatalog();
    }


    // Create historical bookings for system testing
    public void createBookingHistorical(Room room, LocalDate startDate, LocalDate endDate, Guest guest, long totalRate, LocalDate dateToPut) throws IOException {
        Booking booking = new Booking(room, startDate, endDate, guest, totalRate);
        booking.setBookingDate(dateToPut);
        booking.setCheckedOut(true);
        booking.setPaid(true);
        booking.setPaidDate(LocalDate.now());
        booking.setTotalRateWithDates(startDate, endDate);

        if (bookings.get(room.getRoomNumber()) == null){
            ArrayList<Booking> newBookingList = new ArrayList<Booking>();
            newBookingList.add(booking);
            bookings.put(room.getRoomNumber(), newBookingList);
        } else {
            bookings.get(room.getRoomNumber()).add(booking);
        }
        saveBookingCatalog();
    }

    // Remove a booking that has been cancelled prior to cancellation fee activation
    public void deleteBooking (Booking bookingToDelete) throws IOException {
        ArrayList<Booking> bookingsToSearch = new ArrayList<Booking>();
        bookingsToSearch = bookings.get(bookingToDelete.getRoom().getRoomNumber());
        for (int i = 0; i < bookingsToSearch.size(); i++){
            if (bookingsToSearch.get(i).getRoom().getRoomNumber().equals(bookingToDelete.getRoom().getRoomNumber()) &&
                    bookingsToSearch.get(i).getStartDate().equals(bookingToDelete.getStartDate()) &&
                    bookingsToSearch.get(i).getEndDate().equals(bookingToDelete.getEndDate())) {
                bookingsToSearch.remove(i);
                break;
            }

        }
        bookings.replace(bookingToDelete.getRoom().getRoomNumber(), bookingsToSearch);
        saveBookingCatalog();
    }

    // Cancel a booking that has been cancelled after cancellation fee activation
    public void cancelBooking (Booking bookingToCancel) throws IOException {
        long cancelRate = Math.round(bookingToCancel.getRoom().getRate() * 0.8);
        Booking newBooking = new Booking(bookingToCancel);

        newBooking.setCanceledPaid(true);
        newBooking.setPaid(true);
        newBooking.setTotalRate(cancelRate);
        newBooking.setPaidDate(LocalDate.now());

        replaceOldBookingWithNewBooking(bookingToCancel, newBooking);
    }

    // Check availability in order to modify a booking
    public boolean checkNewAvailability (Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate) {
        ArrayList<Booking> bookingList = bookings.get(oldBooking.getRoom().getRoomNumber());
        for (Booking booking: bookingList){
            if (booking.getCanceledPaid()){
                continue;
            }
            if (booking.getRoom().getRoomNumber().equals(oldBooking.getRoom().getRoomNumber()) &&
                    booking.getStartDate().equals(oldBooking.getStartDate()) &&
                    booking.getEndDate().equals(oldBooking.getEndDate())){
                continue;
            }
            if (newEndDate.isBefore(newStartDate.plusDays(1))){
                return false;
            }
            if (newStartDate.isAfter(booking.getStartDate().minusDays(1)) && newStartDate.isBefore(booking.getEndDate().plusDays(1))){
                return false;
            } else if (newEndDate.isAfter(booking.getStartDate().minusDays(1)) && newEndDate.isBefore(booking.getEndDate().plusDays(1))){
                return false;
            }
        }
        return true;
    }

    // Modify a booking with new dates
    public Booking adjustBooking (Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate) throws IOException {
        Booking newBooking = new Booking(oldBooking);

        newBooking.setStartDate(newStartDate);
        newBooking.setEndDate(newEndDate);

        newBooking.setTotalRateWithDates(newStartDate, newEndDate);

        replaceOldBookingWithNewBooking(oldBooking, newBooking);

        return newBooking;
    }

    // Check In Guest
    public void checkInBooking (Booking oldBooking) throws IOException {
        Booking newBooking = new Booking(oldBooking);
        newBooking.setCheckedIn(true);

        replaceOldBookingWithNewBooking(oldBooking, newBooking);
    }

    // Check Out Guest and Initiate Payment
    public void checkOutBooking (Booking oldBooking) throws IOException {
        Booking newBooking = new Booking(oldBooking);
        newBooking.setCheckedIn(false);
        newBooking.setCheckedOut(true);
        newBooking.setPaidDate(LocalDate.now());
        newBooking.setPaid(true);

        replaceOldBookingWithNewBooking(oldBooking, newBooking);
    }

    // Internal for booking replacement operations
    public void replaceOldBookingWithNewBooking (Booking oldBooking, Booking newBooking) throws IOException {
        ArrayList<Booking> bookingList = bookings.get(oldBooking.getRoom().getRoomNumber());
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getRoom().getRoomNumber().equals(oldBooking.getRoom().getRoomNumber()) &&
                    bookingList.get(i).getStartDate().equals(oldBooking.getStartDate()) &&
                    bookingList.get(i).getEndDate().equals(oldBooking.getEndDate())) {
                bookingList.set(i, newBooking);
                break;
            }
        }
        bookings.replace(oldBooking.getRoom().getRoomNumber(), bookingList);
        saveBookingCatalog();
    }

    // Get available rooms when searching specific dates
    public ArrayList<Room> getAvailableRooms (ArrayList<Room> roomList, LocalDate startDate, LocalDate endDate){

        ArrayList<Room> availableRooms = new ArrayList<Room>();

        for (Room room: roomList){

            boolean roomCheck = true;

            if (!bookings.containsKey(room.getRoomNumber())){
                availableRooms.add(room);
                continue;
            }

            for( Booking booking: bookings.get(room.getRoomNumber())){
                if (booking.getCanceledPaid()){
                    continue;
                }
                if (startDate.isAfter(booking.getStartDate().minusDays(1)) && startDate.isBefore(booking.getEndDate().plusDays(1))){
                    roomCheck = false;
                    break;
                } else if (endDate.isAfter(booking.getStartDate().minusDays(1)) && endDate.isBefore(booking.getEndDate().plusDays(1))){
                    roomCheck = false;
                    break;
                } else {
                    continue;
                }
            }

            if (roomCheck){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Get bookings for a specific guest or all guests if User is Clerk - DOES NOT include cancellations
    public ArrayList<Booking> getGuestBookings (User guest){
        ArrayList<Booking> guestBookings = new ArrayList<Booking>();

        if (guest instanceof Clerk){
            for (Map.Entry<String, ArrayList<Booking>> entry: bookings.entrySet() ){
                for (Booking booking: entry.getValue()) {
                    if (booking.getCanceledPaid()) {
                        continue;
                    }
                    guestBookings.add(booking);
                }
            }
        } else if (guest instanceof Guest){
            for (Map.Entry<String, ArrayList<Booking>> entry: bookings.entrySet() ){
                for (Booking booking: entry.getValue()){
                    if (booking.getCanceledPaid()){
                        continue;
                    }
                    if (booking.getGuest().getUserName().equals(guest.getUserName())){
                        guestBookings.add(booking);
                    }
                }
            }
        }
        return guestBookings;
    }

    // Get bookings for a specific guest or all guests if User is Clerk - DOES include paid cancellations (for billing)
    public ArrayList<Booking> getGuestBookingsForPayment (User guest){
        ArrayList<Booking> guestBookings = new ArrayList<Booking>();

        if (guest instanceof Clerk){
            for (Map.Entry<String, ArrayList<Booking>> entry: bookings.entrySet() ){
                guestBookings.addAll(entry.getValue());
            }
        } else if (guest instanceof Guest){
            for (Map.Entry<String, ArrayList<Booking>> entry: bookings.entrySet() ){
                for (Booking booking: entry.getValue()){
                    if (booking.getGuest().getUserName().equals(guest.getUserName())){
                        guestBookings.add(booking);
                    }
                }
            }
        }
        return guestBookings;
    }

    // Adjust guest of booking (for when a guest modifies their profile)
    public void adjustGuestBooking (Guest oldUser, Guest newUser) throws IOException {

        for (Map.Entry<String, ArrayList<Booking>> entry: bookings.entrySet()){
            ArrayList<Booking> bookingList = entry.getValue();
            for (int i = 0; i < bookingList.size(); i++){
                Booking booking = bookingList.get(i);
                if (booking.getGuest().getUserName().equals(oldUser.getUserName())){
                    Booking newBooking = booking;
                    newBooking.setGuest(newUser);
                    bookingList.set(i, newBooking);
                }
            }
            bookings.replace(entry.getKey(), bookingList);
        }
        saveBookingCatalog();
    }


    // Print a single booking to console
    public void viewBooking(Booking booking){
        System.out.println("Room: " + booking.getRoom().getRoomNumber());
        System.out.println("Start Date: " + booking.getStartDate());
        System.out.println("End Date: " + booking.getEndDate());
        System.out.println("Guest: " + booking.getGuest().getUserName());
    }

    // Print all bookings to console
    public void viewAllBookings(){
        for (String key: bookings.keySet()){
            ArrayList<Booking> bookingList = bookings.get(key);
            for (Booking booking: bookingList){
                if (booking.getCanceledPaid()){
                    continue;
                }
                viewBooking(booking);
            }
        }
    }

    // Save serializable after all booking catalog modifications
    public void saveBookingCatalog() throws IOException {
        File bookFile = new File("bookingFile.ser");
        FileOutputStream fileOut = new FileOutputStream(bookFile);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(this);
        objOut.close();
        fileOut.close();
    }

    // Booking Map Getter
    public HashMap<String, ArrayList<Booking>> getBookings() {
        return bookings;
    }

}
