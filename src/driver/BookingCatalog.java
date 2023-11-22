package driver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;

public class BookingCatalog implements Serializable {

    private HashMap<String, ArrayList<Booking>> bookings = new HashMap<String, ArrayList<Booking>>();

    public void createBooking(Room room, LocalDate startDate, LocalDate endDate, Guest guest) throws IOException {
        Booking booking = new Booking(room, startDate, endDate, guest);

        if (bookings.get(room.getRoomNumber()) == null){
            ArrayList<Booking> newBookingList = new ArrayList<Booking>();
            newBookingList.add(booking);
            bookings.put(room.getRoomNumber(), newBookingList);
        } else {
            bookings.get(room.getRoomNumber()).add(booking);
        }

        saveBookingCatalog();
    }

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

    public boolean checkNewAvailability (Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate) {
        ArrayList<Booking> bookingList = bookings.get(oldBooking.getRoom().getRoomNumber());
        for (Booking booking: bookingList){
            if (booking.getRoom().getRoomNumber().equals(oldBooking.getRoom().getRoomNumber()) &&
                    booking.getStartDate().equals(oldBooking.getStartDate()) &&
                    booking.getEndDate().equals(oldBooking.getEndDate())){
                System.out.println("Got into if");
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

    public Booking adjustBooking (Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate) throws IOException {
        ArrayList<Booking> bookingList = bookings.get(oldBooking.getRoom().getRoomNumber());
        Booking newBooking = new Booking(oldBooking);
        newBooking.setStartDate(newStartDate);
        newBooking.setEndDate(newEndDate);
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
        return newBooking;
    }

    public ArrayList<Room> getAvailableRooms (ArrayList<Room> roomList, LocalDate startDate, LocalDate endDate){

        ArrayList<Room> availableRooms = new ArrayList<Room>();

        for (Room room: roomList){

            boolean roomCheck = true;

            for( Booking booking: bookings.get(room.getRoomNumber())){
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

    public void viewAllBookings(){
        for (String key: bookings.keySet()){
            ArrayList<Booking> bookingList = bookings.get(key);
            for (Booking booking: bookingList){
                viewBooking(booking);
            }
        }
    }

    public ArrayList<Booking> getGuestBookings (User guest){
        ArrayList<Booking> guestBookings = new ArrayList<Booking>();
        for (Map.Entry<String, ArrayList<Booking>> entry: bookings.entrySet() ){
            for (Booking booking: entry.getValue()){
                if (booking.getGuest().getUserName().equals(guest.getUserName())){
                    guestBookings.add(booking);
                }
            }
        }
        return guestBookings;
    }

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


    public void viewBooking(Booking booking){
        System.out.println("Room: " + booking.getRoom().getRoomNumber());
        System.out.println("Start Date: " + booking.getStartDate());
        System.out.println("End Date: " + booking.getEndDate());
        System.out.println("Guest: " + booking.getGuest().getUserName());
    }

    public void saveBookingCatalog() throws IOException {
        File bookFile = new File("bookingFile.ser");
        FileOutputStream fileOut = new FileOutputStream(bookFile);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(this);
        objOut.close();
        fileOut.close();
    }

}
