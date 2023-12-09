package driver;

import reservations_interface.CLI_CheckInOut;
import reservations_interface.CLI_Reservation;
import room_interface.CLI_Room_Edit;

import java.io.IOException;
import java.util.Scanner;

public class CLI_Controller {
    Scanner scanner = new Scanner(System.in);

    public void selectOperation(User user) throws IOException {

        while(true){
            if (user instanceof Clerk){
                System.out.println("Please select an operation: Make Reservation, Modify Room, Check In or Out");
                String input = scanner.nextLine().toLowerCase();

                if (input.equals("make reservation")){
                    CLI_Reservation cliReservation = new CLI_Reservation();
                    cliReservation.makeReservation();
                    break;
                } else if (input.equals("modify room")){
                    CLI_Room_Edit cliRoomEdit = new CLI_Room_Edit();
                    cliRoomEdit.editRoom();
                    break;
                } else if (input.equals("check in or out")){
                    CLI_CheckInOut cliCheckInOut = new CLI_CheckInOut();
                    cliCheckInOut.chooseOperation();
                    break;
                } else {
                    System.out.println("Please select a valid operation.");
                }
            } else if (user instanceof Guest){
                CLI_Reservation cliReservation = new CLI_Reservation();
                cliReservation.makeReservation();
                break;
            }

        }
    }
}
