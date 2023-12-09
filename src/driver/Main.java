package driver;

import loginandsignup.CLI_Login;
import loginandsignup.Login;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    // Initialize Catalogs
    static RoomCatalog roomCatalog = new RoomCatalog();
    static BookingCatalog bookingCatalog = new BookingCatalog();
    static UserCatalog userCatalog = new UserCatalog();

    public static MasterController masterController;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Saves only for resetting initial data for testing and demonstations
        //roomCatalog.saveRoomCatalog();
        //bookingCatalog.saveBookingCatalog();
        //userCatalog.saveUserCatalog();


        roomCatalog = loadRoomCatalog();
        bookingCatalog = loadBookingCatalog();
        userCatalog = loadUserCatalog();




        // Set Up Code
        /*
        userCatalog.adminSignUp();
        userCatalog.guestSignUp("nick", "nick@baylor.edu", "hi", false, "12345678");
        userCatalog.guestSignUp("jaired", "jaired@baylor.edu", "hi", false, "87654321");
        userCatalog.guestSignUp("joshua", "joshua@baylor.edu", "hi", true, "Delta Air Lines");
        userCatalog.clerkSignUp("George","george@hotel.com");


        bookingCatalog.viewAllBookings();



        roomCatalog.createRoom("1", true, "Full", 2, "Comfort", 150);
        roomCatalog.createRoom("2", false, "Queen", 2, "Comfort", 150);
        roomCatalog.createRoom("3", true, "King", 1, "Comfort", 120);
        roomCatalog.createRoom("4", false, "Full", 2, "Comfort", 120);
        roomCatalog.createRoom("5", true, "Queen", 1, "Comfort", 100);
        roomCatalog.createRoom("6", false, "King", 2, "Executive", 400);
        roomCatalog.createRoom("7", true, "King", 2, "Executive", 350);
        roomCatalog.createRoom("8", false, "King", 2, "Executive", 350);
        roomCatalog.createRoom("9", true, "Full", 1, "Business", 200);
        roomCatalog.createRoom("10", false, "Full", 2, "Economy", 80);
        roomCatalog.createRoom("11", true, "Queen", 1, "Business", 220);
        roomCatalog.createRoom("12", false, "Twin", 2, "Economy", 100);
        roomCatalog.createRoom("13", true, "Queen", 1, "Executive", 500);
        roomCatalog.createRoom("14", false, "Twin", 2, "Comfort", 130);
        roomCatalog.createRoom("15", true, "Queen", 1, "Economy", 90);
        roomCatalog.createRoom("16", false, "Full", 2, "Executive", 550);
        roomCatalog.createRoom("17", false, "King", 1, "Business", 250);
        roomCatalog.createRoom("18", true, "Queen", 2, "Business", 210);
        roomCatalog.createRoom("19", false, "Queen", 1, "Eeconomy", 100);
        roomCatalog.createRoom("20", true, "Full", 1, "Economy", 110);
        roomCatalog.createRoom("21", true, "Full", 2, "Comfort", 150);
        roomCatalog.createRoom("22", false, "Queen", 2, "Comfort", 150);
        roomCatalog.createRoom("23", true, "King", 1, "Comfort", 120);
        roomCatalog.createRoom("24", false, "Full", 2, "Comfort", 120);
        roomCatalog.createRoom("25", true, "Queen", 1, "Comfort", 100);
        roomCatalog.createRoom("26", false, "King", 2, "Executive", 400);
        roomCatalog.createRoom("27", true, "King", 2, "Executive", 350);
        roomCatalog.createRoom("28", false, "King", 2, "Executive", 350);
        roomCatalog.createRoom("29", true, "Full", 1, "Business", 200);
        roomCatalog.createRoom("30", false, "Full", 2, "Economy", 80);
        roomCatalog.createRoom("31", true, "Queen", 1, "Business", 220);
        roomCatalog.createRoom("32", false, "Twin", 2, "Economy", 100);
        roomCatalog.createRoom("33", true, "Queen", 1, "Executive", 500);
        roomCatalog.createRoom("34", false, "Twin", 2, "Comfort", 130);
        roomCatalog.createRoom("35", true, "Queen", 1, "Economy", 90);
        roomCatalog.createRoom("36", false, "Full", 2, "Executive", 550);
        roomCatalog.createRoom("37", false, "King", 1, "Business", 250);
        roomCatalog.createRoom("38", true, "Queen", 2, "Business", 210);
        roomCatalog.createRoom("39", false, "Queen", 1, "Eeconomy", 100);
        roomCatalog.createRoom("40", true, "Full", 1, "Economy", 110);



        for (int i = 1; i < 6; i++){
            bookingCatalog.createBooking(roomCatalog.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 12, 18), LocalDate.of(2023, 12, 20), (Guest) userCatalog.getUsers().get("nick@baylor.edu"), roomCatalog.getRooms().get(Integer.toString(i)).getRate() * LocalDate.of(2023, 12, 18).until(LocalDate.of(2023, 12, 20), ChronoUnit.DAYS));
        }
        for (int i = 14; i < 19; i++){
            bookingCatalog.createBooking(roomCatalog.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 12, 18), LocalDate.of(2023, 12, 26), (Guest) userCatalog.getUsers().get("jaired@baylor.edu"), roomCatalog.getRooms().get(Integer.toString(i)).getRate() * LocalDate.of(2023, 12, 18).until(LocalDate.of(2023, 12, 26), ChronoUnit.DAYS));
        }
        for (int i = 24; i < 28; i++){
            bookingCatalog.createBooking(roomCatalog.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 12, 22), LocalDate.of(2023, 12, 27), (Guest) userCatalog.getUsers().get("nick@baylor.edu"), roomCatalog.getRooms().get(Integer.toString(i)).getRate() * LocalDate.of(2023, 12, 22).until(LocalDate.of(2023, 12, 27), ChronoUnit.DAYS));
        }
        for (int i = 31; i < 37; i++){
            bookingCatalog.createBooking(roomCatalog.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 12, 28), LocalDate.of(2023, 12, 31), (Guest) userCatalog.getUsers().get("jaired@baylor.edu"), roomCatalog.getRooms().get(Integer.toString(i)).getRate() * LocalDate.of(2023, 12, 28).until(LocalDate.of(2023, 12, 31), ChronoUnit.DAYS));
        }
        bookingCatalog.createBooking(roomCatalog.getRooms().get("4"), LocalDate.of(2023, 12, 22), LocalDate.of(2023, 12, 30), (Guest) userCatalog.getUsers().get("joshua@baylor.edu"), roomCatalog.getRooms().get("4").getRate() * LocalDate.of(2023, 12, 22).until(LocalDate.of(2023, 12, 30), ChronoUnit.DAYS));
        bookingCatalog.createBooking(roomCatalog.getRooms().get("5"), LocalDate.of(2023, 12, 25), LocalDate.of(2023, 12, 28), (Guest) userCatalog.getUsers().get("joshua@baylor.edu"), roomCatalog.getRooms().get("5").getRate() * LocalDate.of(2023, 12, 25).until(LocalDate.of(2023, 12, 28), ChronoUnit.DAYS));
        bookingCatalog.createBooking(roomCatalog.getRooms().get("6"), LocalDate.of(2023, 12, 27), LocalDate.of(2023, 12, 31), (Guest) userCatalog.getUsers().get("joshua@baylor.edu"), roomCatalog.getRooms().get("6").getRate() * LocalDate.of(2023, 12, 27).until(LocalDate.of(2023, 12, 31), ChronoUnit.DAYS));
        bookingCatalog.createBooking(roomCatalog.getRooms().get("7"), LocalDate.of(2023, 12, 18), LocalDate.of(2023, 12, 21), (Guest) userCatalog.getUsers().get("nick@baylor.edu"), roomCatalog.getRooms().get("7").getRate() * LocalDate.of(2023, 12, 18).until(LocalDate.of(2023, 12, 21), ChronoUnit.DAYS));
        bookingCatalog.createBooking(roomCatalog.getRooms().get("12"), LocalDate.of(2023, 12, 24), LocalDate.of(2023, 12, 30), (Guest) userCatalog.getUsers().get("nick@baylor.edu"), roomCatalog.getRooms().get("12").getRate() * LocalDate.of(2023, 12, 24).until(LocalDate.of(2023, 12, 30), ChronoUnit.DAYS));
        bookingCatalog.createBooking(roomCatalog.getRooms().get("28"), LocalDate.of(2023, 12, 9), LocalDate.of(2023, 12, 30), (Guest) userCatalog.getUsers().get("nick@baylor.edu"), roomCatalog.getRooms().get("12").getRate() * LocalDate.of(2023, 12, 9).until(LocalDate.of(2023, 12, 30), ChronoUnit.DAYS), LocalDate.now().minusDays(4));
        bookingCatalog.createBookingHistorical(roomCatalog.getRooms().get("16"), LocalDate.of(2023, 11, 24), LocalDate.of(2023, 11, 30), (Guest) userCatalog.getUsers().get("nick@baylor.edu"), roomCatalog.getRooms().get("12").getRate() * LocalDate.of(2023, 11, 24).until(LocalDate.of(2023, 11, 30), ChronoUnit.DAYS), LocalDate.now().minusDays(4));
        bookingCatalog.createBookingHistorical(roomCatalog.getRooms().get("32"), LocalDate.of(2023, 11, 24), LocalDate.of(2023, 11, 30), (Guest) userCatalog.getUsers().get("nick@baylor.edu"), roomCatalog.getRooms().get("12").getRate() * LocalDate.of(2023, 11, 24).until(LocalDate.of(2023, 11, 30), ChronoUnit.DAYS), LocalDate.now().minusDays(4));



        for (String key: userCatalog.getUsers().keySet()){
            System.out.println(key);
        }

         */



        // Reservation controller and profile controller initialized for master controller use
        ReservationController reservationController = new ReservationController(bookingCatalog, roomCatalog);

        ProfileController profileController = new ProfileController(userCatalog);

        masterController = new MasterController(profileController, reservationController);

        // Start GUI login and CLI login
        new Login();
        CLI_Login cliLogin = new CLI_Login();
        cliLogin.login();

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

    public static BookingCatalog loadBookingCatalog() throws IOException, ClassNotFoundException {

        BookingCatalog bookCat = null;
        FileInputStream fileIn = new FileInputStream("bookingFile.ser");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        bookCat = (BookingCatalog) objIn.readObject();
        objIn.close();
        fileIn.close();
        return bookCat;
    }

    public static void saveUsers(HashMap<String, User> userMap) throws IOException {
        File userFile = new File("userFile.ser");
        FileOutputStream fileOut = new FileOutputStream(userFile);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(userMap);
        objOut.close();
        fileOut.close();
    }

    public static UserCatalog loadUserCatalog() throws IOException, ClassNotFoundException {

        UserCatalog userCatalog;
        FileInputStream fileIn = new FileInputStream("userFile.ser");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        userCatalog = (UserCatalog) objIn.readObject();
        objIn.close();
        fileIn.close();
        return userCatalog;
    }


}

