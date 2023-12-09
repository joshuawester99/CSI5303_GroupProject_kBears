package driver;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReservationController {

    // Stores Bookings
    BookingCatalog bookingCatalog;

    // Stores Rooms
    RoomCatalog roomCatalog;

    // Constructor
    public ReservationController(BookingCatalog bookingCatalog, RoomCatalog roomCatalog) {
        this.bookingCatalog = bookingCatalog;
        this.roomCatalog = roomCatalog;
    }

    // Applies filters and dates to find available rooms based on bookings in the bookings catalog
    public ArrayList<Room> getAvailableRooms(Boolean smoking, String bedType, int bedNumber, String quality, LocalDate startDate, LocalDate endDate){
        ArrayList<Room> roomList = bookingCatalog.getAvailableRooms(roomCatalog.getMatchingRooms(smoking, bedType, bedNumber, quality), startDate, endDate);
        printRooms(roomList);
        return roomList;
    }


    // Print rooms to console
    public void printRooms(ArrayList<Room> roomList){
        for (Room roomToPrint: roomList){
            System.out.println("Room Number: " + roomToPrint.getRoomNumber());
            System.out.println("Smoking: " + roomToPrint.getSmoking());
            System.out.println("Bed Number: " + roomToPrint.getBedNumber());
            System.out.println("Bed Type: " + roomToPrint.getBedType());
            System.out.println("Quality: " + roomToPrint.getQuality());
            System.out.println();
        }
    }

    // CLI select room
    public Room selectRoom (ArrayList<Room> roomList){
        Scanner scan = new Scanner(System.in);
        String selectedRoomNumber;

        while (true){
            System.out.println("Please select a room number: ");
            selectedRoomNumber = scan.nextLine();

            for (Room room: roomList){
                if (selectedRoomNumber.equals(room.getRoomNumber())){
                    roomCatalog.viewRoom(selectedRoomNumber);
                    return room;
                }
            }

            System.out.println("Invalid Room Number!");

        }

    }

    // Retrieve a list of all rooms
    public ArrayList<Room> getAllRooms(){
        ArrayList<Room> roomList = new ArrayList<Room>();
        HashMap<String, Room> roomMap = roomCatalog.getRooms();

        for (Map.Entry<String, Room> entry: roomMap.entrySet()){
            roomList.add(entry.getValue());
        }
        return roomList;
    }

    // Retrieve a list of specific rooms based on filters (without dates)
    public ArrayList<Room> getFilteredRooms (String smoking, String bedType, String bedNumber, String quality){
        ArrayList<Room> roomList = new ArrayList<Room>();
        HashMap<String, Room> roomMap = roomCatalog.getRooms();

        if (smoking.equals("Smoking")){
            smoking = "true";
        }
        if (smoking.equals("Non-Smoking")){
            smoking = "false";
        }

        if (!bedNumber.equals("Bed Number")){
            bedNumber = bedNumber.substring(0,1);
        }

        for (Map.Entry<String, Room> entry: roomMap.entrySet()){
            if (!smoking.equals(String.valueOf(entry.getValue().getSmoking())) && !smoking.equals("Smoking Pref.")){
                continue;
            }
            if (!bedType.equals(entry.getValue().getBedType()) && !bedType.equals("Bed Type")){
                continue;
            }
            if (!bedNumber.equals(Integer.toString(entry.getValue().getBedNumber())) && !bedNumber.equals("Bed Number")){
                continue;
            }
            if (!quality.equals(entry.getValue().getQuality()) && !quality.equals("Quality")){
                continue;
            }
            roomList.add(entry.getValue());
        }
        return roomList;
    }

    // Query booking catalog for which rooms in list are available
    public ArrayList<Room> getAvailableRooms(ArrayList<Room> roomList, LocalDate startDate, LocalDate endDate){
        return bookingCatalog.getAvailableRooms(roomList, startDate, endDate);
    }

    // Adjust the guest of a booking when guest modifies profile
    public void adjustGuestBooking (Guest oldGuest, Guest newGuest) throws IOException {
        bookingCatalog.adjustGuestBooking(oldGuest, newGuest);
    }

    // Get bookings for all guests or specific guest
    public ArrayList<Booking> getGuestBookings (User guest){
        return bookingCatalog.getGuestBookings(guest);
    }

    // Get bookings for Billing Report (includes cancelled bookings where a fee was paid)
    public ArrayList<Booking> getGuestBookingsForPayment (User guest){
        return bookingCatalog.getGuestBookingsForPayment(guest);
    }

    // Remove a booking
    public void deleteBooking(Booking booking) throws IOException {
        if (LocalDate.now().isBefore(booking.getBookingDate().plusDays(3))){
            bookingCatalog.deleteBooking(booking);
        } else {
            bookingCatalog.cancelBooking(booking);
        }
    }

    // Check availability of a requested modification
    public boolean checkNewAvailability(Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate){
        return bookingCatalog.checkNewAvailability(oldBooking, newStartDate, newEndDate);
    }

    // Modify a booking
    public Booking adjustBooking(Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate) throws IOException {
        return bookingCatalog.adjustBooking(oldBooking, newStartDate, newEndDate);
    }

    // Modify a Room
    public void modifyRoom(Room oldRoom, String newSmoking, String newQuality, String newBedType, String newBedNumber) throws IOException {
        roomCatalog.modifyRoom(oldRoom, newSmoking, newQuality, newBedType, newBedNumber);
    }

    // Check a guest in (show room as occupied, booking as checked in)
    public void checkIn(Booking booking) throws IOException {
        roomCatalog.checkIn(booking.getRoom());
        bookingCatalog.checkInBooking(booking);
    }

    // Check a guest out (show room as unoccupied, booking as checked out)
    public void checkOut(Booking booking) throws IOException {
        roomCatalog.checkOut(booking.getRoom());
        bookingCatalog.checkOutBooking(booking);
    }

    public boolean roomExists(String roomNumber){
        return roomCatalog.roomExists(roomNumber);
    }

}
