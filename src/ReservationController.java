import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationController {

    BookingCatalog bookingCatalog;

    RoomCatalog roomCatalog;

    public ReservationController(BookingCatalog bookingCatalog, RoomCatalog roomCatalog) {
        this.bookingCatalog = bookingCatalog;
        this.roomCatalog = roomCatalog;
    }

    public ArrayList<Room> getAvailableRooms(Boolean smoking, String bedType, int bedNumber, String quality, LocalDate startDate, LocalDate endDate){
        ArrayList<Room> roomList = bookingCatalog.getAvailableRooms(roomCatalog.getMatchingRooms(smoking, bedType, bedNumber, quality), startDate, endDate);
        printRooms(roomList);
        return roomList;
    }

    public void makeReservation(Guest guest) throws IOException {

        Scanner scan = new Scanner(System.in);

        Boolean smoking;
        String bedType;
        int bedNumber;
        String quality;
        int startYear;
        int startMonth;
        int startDay;
        int endYear;
        int endMonth;
        int endDay;

        System.out.println("Please enter the smoking status (true or false): ");
        smoking = Boolean.valueOf(scan.nextLine());

        System.out.println("Please enter the bed type: ");
        bedType = scan.nextLine();

        System.out.println("Please enter the bed number: ");
        bedNumber = Integer.parseInt(scan.nextLine());

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

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        ArrayList<Room> availableRooms = getAvailableRooms(smoking, bedType, bedNumber, quality, startDate, endDate);
        Room chosenRoom = selectRoom(availableRooms);
        bookingCatalog.createBooking(chosenRoom, startDate, endDate, guest);
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




    public static void saveRoomCatalog(RoomCatalog roomCatalog) throws IOException {
        File roomFile = new File("roomFile.ser");
        FileOutputStream fileOut = new FileOutputStream(roomFile);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(roomCatalog);
        objOut.close();
        fileOut.close();
    }

    public static RoomCatalog loadRoomCatalog() throws IOException, ClassNotFoundException {

        RoomCatalog roomCat = null;
        FileInputStream fileIn = new FileInputStream("roomFile.ser");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        roomCat = (RoomCatalog) objIn.readObject();
        objIn.close();
        fileIn.close();
        return roomCat;
    }

}
