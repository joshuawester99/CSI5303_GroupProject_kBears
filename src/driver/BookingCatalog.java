package driver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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


    public void viewBooking(Booking booking){
        System.out.println("Room: " + booking.getRoom().getRoomNumber());
        System.out.println("Start Date: " + booking.getStartDate());
        System.out.println("End Date: " + booking.getEndDate());
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
