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
        System.out.print(roomToPrint);
    }

    public void createRoom(String roomNumber, boolean smoking, String bedType, int bedNumber, String quality, int rate) throws IOException {
        rooms.put(roomNumber, new Room(roomNumber, smoking, bedType, bedNumber, quality, rate));
        saveRoomCatalog();
    }

    // Get rooms that match filters
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

    // Update room to occupied
    public void checkIn(Room room) throws IOException {
        Room roomUpdate = room;
        roomUpdate.setStatus("Occupied");
        rooms.replace(room.getRoomNumber(), roomUpdate);
        saveRoomCatalog();
    }

    // Update room to unoccupied
    public void checkOut(Room room) throws IOException {
        Room roomUpdate = room;
        roomUpdate.setStatus("Unoccupied");
        rooms.replace(room.getRoomNumber(), roomUpdate);
        saveRoomCatalog();
    }

    // Modify room details
    public void modifyRoom(Room oldRoom, String newSmoking, String newQuality, String newBedType, String newBedNumber) throws IOException {
        Room newRoom = new Room(oldRoom);


        if (!newSmoking.equals("")){
            if (newSmoking.equals("Smoking")){
                newRoom.setSmoking(true);
            } else if (newSmoking.equals("Non-Smoking")){
                newRoom.setSmoking(false);
            }
        }
        if (!newBedNumber.equals("")){
            if (newBedNumber.equals("1")){
                newRoom.setBedNumber(1);
            } else if (newBedNumber.equals("2")){
                newRoom.setBedNumber(2);
            } else if (newBedNumber.equals("3")){
                newRoom.setBedNumber(3);
            }
        }
        if (!newBedType.equals("")){
            newRoom.setBedType(newBedType);
        }
        if (!newQuality.equals("")){
            newRoom.setQuality(newQuality);
        }

        rooms.replace(oldRoom.getRoomNumber(), newRoom);
        saveRoomCatalog();
    }

    // Check if room exists
    public boolean roomExists(String roomNumber){
        return rooms.containsKey(roomNumber);
    }

    // Save catalog to serializable file
    public void saveRoomCatalog() throws IOException {
        File roomFile = new File("roomFile.ser");
        FileOutputStream fileOut = new FileOutputStream(roomFile);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(this);
        objOut.close();
        fileOut.close();
    }



}
