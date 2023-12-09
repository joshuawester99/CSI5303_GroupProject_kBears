package room_interface;

import driver.Main;

import java.io.IOException;
import java.util.Scanner;

public class CLI_Room_Edit {
    String roomNumber;
    String smoking;
    String bedType;
    String bedNumber;
    String quality;
    Scanner scan = new Scanner(System.in);

    // Check for room modification options and modify room if exists
    public void editRoom() throws IOException {
        while(true){

            while(true){
                System.out.println("Please enter the room number:");
                roomNumber = scan.nextLine();
                if (!Main.masterController.roomExists(roomNumber)){
                    System.out.println("Room Does Not Exist");
                    continue;
                } else {
                    break;
                }
            }

            System.out.println("ROOM DETAILS:");
            System.out.println(Main.masterController.getRoom(roomNumber));

            while(true){
                System.out.println("Please enter the smoking status (Smoking or Non-Smoking)");
                smoking = scan.nextLine();
                if (smoking.equals("Smoking") || smoking.equals("Non-Smoking")){
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }
            }

            while(true){
                System.out.println("Please enter the bed type (Twin, Full, Queen, or King)");
                bedType = scan.nextLine();
                if (bedType.equals("Twin") || bedType.equals("Full") || bedType.equals("Queen") || bedType.equals("King")){
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }
            }

            while(true){
                System.out.println("Please enter the bed number (1 or 2)");
                bedNumber = scan.nextLine();
                if (bedNumber.equals("1") || bedNumber.equals("2")){
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }
            }

            while(true){
                System.out.println("Please enter the quality (Economy, Comfort, Business, or Executive");
                quality = scan.nextLine();
                if (quality.equals("Economy") || quality.equals("Comfort") || quality.equals("Business") || quality.equals("Executive")){
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }
            }
            Main.masterController.modifyRoom(Main.masterController.getRoom(roomNumber), smoking, bedType, bedNumber, quality);
            System.out.println("Room Edited!");
            break;
        }
    }
}
