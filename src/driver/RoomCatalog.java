package driver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RoomCatalog implements Serializable {

    private HashMap<String, Room> rooms = new HashMap<String, Room>();

    private enum roomModificationOption { SMOKING, BEDTYPE, BEDNUMBER, QUALITY }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    public void putRoom(String id, Room room){
        rooms.put(id, room);
    }

    public void viewAllRooms(){

        System.out.println("HERE ARE THE ROOMS");
        System.out.println();

        for (String key: rooms.keySet()){
            viewRoom(key);
        }
    }

    public void viewRoom(String roomNumber){
        Room roomToPrint = rooms.get(roomNumber);
        System.out.println("Room Number: " + roomToPrint.getRoomNumber());
        System.out.println("Smoking: " + roomToPrint.getSmoking());
        System.out.println("Bed Number: " + roomToPrint.getBedNumber());
        System.out.println("Bed Type: " + roomToPrint.getBedType());
        System.out.println("Quality: " + roomToPrint.getQuality());
        System.out.println();
    }

    public void createRoom(String roomNumber, boolean smoking, String bedType, int bedNumber, String quality) throws IOException {
        Scanner scan = new Scanner(System.in);


        //System.out.println("Please enter the room number: ");
        //roomNumber = scan.nextLine();

        //System.out.println("Please enter the smoking status (true or false): ");
        //smoking = Boolean.valueOf(scan.nextLine());

        //System.out.println("Please enter the bed type: ");
        //bedType = scan.nextLine();

        //System.out.println("Please enter the bed number: ");
        //bedNumber = Integer.parseInt(scan.nextLine());

        //System.out.println("Please enter the quality level: ");
        //quality = scan.nextLine();

        rooms.put(roomNumber, new Room(roomNumber, smoking, bedType, bedNumber, quality));
        saveRoomCatalog();
    }

    public void modifyRoom() {

        Scanner scan = new Scanner(System.in);

        viewAllRooms();

        String roomNumber;

        while (true){
            System.out.println("What room would you like to modify?");
            roomNumber = scan.nextLine();
            if (rooms.containsKey(roomNumber)){
                break;
            } else {
                System.out.println("Invalid Selection!");
            }

        }

        Room modifiedRoom = rooms.get(roomNumber);
        String inputChoice;

        while (true){
            System.out.println("What room attribute would you like to change? (smoking, bedType, bedNumber, quality)");
            inputChoice = scan.nextLine().toUpperCase();
            boolean isValid = false;

            for (roomModificationOption value: roomModificationOption.values()){
                if (value.name().equals(inputChoice)){
                    isValid = true;
                }
            }
            if (isValid){
                break;
            }

            System.out.println("Invalid Choice!");
        }

        roomModificationOption modifyChoice = roomModificationOption.valueOf(inputChoice);

        switch (modifyChoice) {
            case SMOKING:
                while (true){
                    System.out.println("Set smoking to true or false:");
                    String choice = scan.nextLine().toUpperCase();
                    if (choice.equals("TRUE")){
                        modifiedRoom.setSmoking(true);
                        break;
                    } else if (choice.equals("FALSE")){
                        modifiedRoom.setSmoking(false);
                        break;
                    } else {
                        System.out.println("Invalid Selection!");
                    }
                }
                break;

            case BEDNUMBER:
                while (true){
                    System.out.println("Set number of beds:");
                    String choice = scan.nextLine();
                    int bedValue = 0;

                    try{
                        bedValue = Integer.parseInt(choice);
                    } catch (NumberFormatException e){
                        System.out.println("Please enter an integer value.");
                        continue;
                    }
                    modifiedRoom.setBedNumber(bedValue);
                    break;
                }
                break;

            case BEDTYPE:
                System.out.println("Set bed type (King, Queen, Full, Twin):");
                String bedChoice = scan.nextLine();
                modifiedRoom.setBedType(bedChoice);
                break;

            case QUALITY:
                System.out.println("Set quality (economy, comfort, executive):");
                String qualityChoice = scan.nextLine().toLowerCase();
                modifiedRoom.setQuality(qualityChoice);
                break;

        }
        rooms.remove(roomNumber);
        rooms.put(roomNumber, modifiedRoom);
        System.out.println("Attribute changed!");
        System.out.println();
        viewRoom(roomNumber);

    }

    public ArrayList<Room> getMatchingRooms(Boolean smoking, String bedType, int bedNumber, String quality){

        ArrayList<Room> roomsMatchingCriteria = new ArrayList<Room>();

        for (Map.Entry<String, Room> mapElement: rooms.entrySet()) {
            if (mapElement.getValue().getSmoking() != smoking){
                break;
            }
            if (!mapElement.getValue().getBedType().equals(bedType)){
                break;
            }
            if (mapElement.getValue().getBedNumber() != bedNumber){
                break;
            }
            if (!mapElement.getValue().getQuality().equals(quality)){
                break;
            }

            roomsMatchingCriteria.add(mapElement.getValue());
        }

        return roomsMatchingCriteria;
    }

    public void saveRoomCatalog() throws IOException {
        File roomFile = new File("roomFile.ser");
        FileOutputStream fileOut = new FileOutputStream(roomFile);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(this);
        objOut.close();
        fileOut.close();
    }



}
