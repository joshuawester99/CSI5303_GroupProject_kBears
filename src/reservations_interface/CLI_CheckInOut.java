package reservations_interface;

import driver.Booking;
import driver.Guest;
import driver.Main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI_CheckInOut {
    Scanner scan = new Scanner(System.in);

    Guest guestAtDesk = new Guest();

    // Choose check in or check out
    public void chooseOperation() throws IOException {
        while(true){
            System.out.println("Please select: Check In or Check Out");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("check in")) {
                checkIn();
                break;
            } else if (input.equals("check out")){
                checkOut();
                break;
            } else {
                System.out.println("Please select a valid output");
            }
        }
    }

    // Find guest from username
    public Guest searchForGuest(){
        while(true){
            System.out.println("Please enter the guest's username");
            String inputUsername = scan.nextLine();
            if (Main.masterController.checkIfGuest(inputUsername)){
                return Main.masterController.getGuest(inputUsername);
            } else {
                System.out.println("Invalid username!");
            }
        }
    }

    // Check guest in
    public void checkIn() throws IOException {

        while(true){
            guestAtDesk = searchForGuest();
            ArrayList<Booking> guestBookings = Main.masterController.getGuestBookings(guestAtDesk);
            if (guestBookings.isEmpty()){
                System.out.println("No Bookings for this guest");
                continue;
            }

            ArrayList<Booking> bookingsToCheckIn = new ArrayList<Booking>();
            for (Booking booking: guestBookings){
                if (booking.getStartDate().equals(LocalDate.now()) & !booking.getCheckedIn()){
                    bookingsToCheckIn.add(booking);
                }
            }
            if (bookingsToCheckIn.isEmpty()){
                System.out.println("No bookings to check in for this guest");
                continue;
            }
            for (int i = 0; i < bookingsToCheckIn.size(); i++){
                Booking booking = bookingsToCheckIn.get(i);
                System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
                while(true){
                    System.out.println("Would you like to check this room in? (y or n)");
                    String inputSelect = scan.nextLine().toLowerCase();

                    if (inputSelect.equals("n")){
                        break;
                    } else if (inputSelect.equals("y")){
                        Main.masterController.checkIn(booking);
                        System.out.println("Checked In!");
                        return;
                    } else {
                        System.out.println("Invalid Selection!");
                        continue;
                    }
                }
            }
        }
    }

    // Check guest out
    public void checkOut() throws IOException {

        while(true){
            guestAtDesk = searchForGuest();
            ArrayList<Booking> guestBookings = Main.masterController.getGuestBookings(guestAtDesk);
            if (guestBookings.isEmpty()){
                System.out.println("No Bookings for this guest");
                continue;
            }

            ArrayList<Booking> bookingsToCheckOut = new ArrayList<Booking>();
            for (Booking booking: guestBookings){
                if (booking.getCheckedIn() & !booking.getCheckedOut()){
                    bookingsToCheckOut.add(booking);
                }
            }
            if (bookingsToCheckOut.isEmpty()){
                System.out.println("No bookings to check out for this guest");
                continue;
            }
            for (int i = 0; i < bookingsToCheckOut.size(); i++){
                Booking booking = bookingsToCheckOut.get(i);
                System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
                while(true){
                    System.out.println("Would you like to check this room out? (y or n)");
                    String inputSelect = scan.nextLine().toLowerCase();

                    if (inputSelect.equals("n")){
                        break;
                    } else if (inputSelect.equals("y")){
                        Main.masterController.checkOut(booking);
                        System.out.println("Checked Out!");
                        return;
                    } else {
                        System.out.println("Invalid Selection!");
                        continue;
                    }
                }
            }
        }



    }
}
