package reservations_interface;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import driver.Guest;
import driver.Main;
import driver.Room;

public class CLI_Reservation {

    Scanner scan = new Scanner(System.in);

    public void makeReservation() throws IOException {

        Boolean smokingInput;
        String smoking;
        String bedType;
        int bedNumberInput;
        String bedNumber;
        String quality;
        int startYear;
        int startMonth;
        int startDay;
        int endYear;
        int endMonth;
        int endDay;
        LocalDate startDate;
        LocalDate endDate;
        Room chosenRoom;

        ArrayList<Room> filteredRooms = new ArrayList<Room>();
        ArrayList<Room> availableRooms = new ArrayList<Room>();

        while (true) {
            try{
                System.out.println("Please enter the smoking status (true or false): ");
                smokingInput = Boolean.valueOf(scan.nextLine());

                if (smokingInput){
                    smoking = "Smoking";
                } else {
                    smoking = "Non-Smoking";
                }

                System.out.println("Please enter the bed type: ");
                bedType = scan.nextLine();

                System.out.println("Please enter the bed number: ");
                bedNumberInput = Integer.parseInt(scan.nextLine());

                if (bedNumberInput == 1){
                    bedNumber = "1 Bed";
                } else if (bedNumberInput == 2){
                    bedNumber = "2 Beds";
                } else if (bedNumberInput == 3){
                    bedNumber = "3 Beds";
                } else {
                    bedNumber = "None";
                }

                System.out.println("Please enter the quality level: ");
                quality = scan.nextLine();

                System.out.println("Please enter the start year (integer form): ");
                startYear = Integer.parseInt(scan.nextLine());

                System.out.println("Please enter the start month (integer form): ");
                startMonth = Integer.parseInt(scan.nextLine());

                System.out.println("Please enter the start day (integer form): ");
                startDay = Integer.parseInt(scan.nextLine());

                System.out.println("Please enter the end year (integer form): ");
                endYear = Integer.parseInt(scan.nextLine());

                System.out.println("Please enter the end month (integer form): ");
                endMonth = Integer.parseInt(scan.nextLine());

                System.out.println("Please enter the endDay (integer form): ");
                endDay = Integer.parseInt(scan.nextLine());

                startDate = LocalDate.of(startYear, startMonth, startDay);
                endDate = LocalDate.of(endYear, endMonth, endDay);

                break;

            } catch (NumberFormatException e){
                System.out.println("Invalid Number Input! Please re-enter the details!");
            } catch (java.time.DateTimeException e){
                System.out.println("Provided dates cannot be converted! Please re-enter details!");
            }

        }

        filteredRooms = Main.masterController.getFilteredRooms(smoking, bedType, bedNumber, quality);
        availableRooms = Main.masterController.getAvailableRooms(filteredRooms, startDate, endDate);

        System.out.println("Here are the available rooms:");

        printRooms(availableRooms);

        chosenRoom = selectRoom(availableRooms);

        if (Main.masterController.checkUserInstance().equals("Guest")){
            Main.masterController.bookRoom(chosenRoom, startDate, endDate, (Guest) Main.masterController.getCurrentUser());
        } else {
            Guest inputGuest = getGuest();
            Main.masterController.bookRoom(chosenRoom, startDate, endDate, inputGuest);
            System.out.println("Room booked!");
        }



    }
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

    public Room selectRoom (ArrayList<Room> roomList){
        Scanner scan = new Scanner(System.in);
        String selectedRoomNumber;

        while (true){
            System.out.println("Please select a room number to book: ");
            selectedRoomNumber = scan.nextLine();

            for (Room room: roomList){
                if (selectedRoomNumber.equals(room.getRoomNumber())){
                    return room;
                }
            }

            System.out.println("Invalid Room Number!");

        }
    }

    public Guest getGuest(){
        String inputUsername;

        while (true){
            System.out.println("What is the username of the guest for this room?");
            inputUsername = scan.nextLine();
            if (Main.masterController.checkIfGuest(inputUsername)){
                return Main.masterController.getGuest(inputUsername);
            } else {
                System.out.println("Invalid guest username!");
            }
        }
    }
}
