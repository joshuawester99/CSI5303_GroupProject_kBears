package driver;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import loginandsignup.LoginController;
import room_interface.RoomController;
import driver.*;
import loginandsignup.*;
import reservations_interface.*;
import room_interface.*;

public class Main {

    static RoomCatalog roomCatalog = new RoomCatalog();
    static BookingCatalog bookingCatalog = new BookingCatalog();
    static UserCatalog userCatalog = new UserCatalog();
    static HashMap<String, User> users = new HashMap<String, User>();

    public static MasterController masterController;
    static int guestIncrement = 1;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //roomCatalog.saveRoomCatalog();
        //bookingCatalog.saveBookingCatalog();
        //userCatalog.saveUserCatalog();
        
        File file = new File(".");
        for(String fileNames : file.list()) System.out.println(fileNames);
        
        roomCatalog = loadRoomCatalog();
        bookingCatalog = loadBookingCatalog();
        userCatalog = loadUserCatalog();

        /*
        roomCatalog.createRoom("1", true, "Full", 2, "Comfort");
        roomCatalog.createRoom("2", false, "Queen", 2, "Comfort");
        roomCatalog.createRoom("3", true, "King", 1, "Comfort");
        roomCatalog.createRoom("4", false, "Full", 2, "Comfort");
        roomCatalog.createRoom("5", true, "Queen", 1, "Comfort");
        roomCatalog.createRoom("6", false, "King", 2, "Executive");
        roomCatalog.createRoom("7", true, "King", 2, "Executive");
        roomCatalog.createRoom("8", false, "King", 2, "Executive");
        roomCatalog.createRoom("9", true, "Queen", 3, "Executive");

        for (int i = 1; i < 10; i++){
            bookingCatalog.createBooking(roomCatalog.getRooms().get(Integer.toString(i)), LocalDate.of(2023, 11, 8), LocalDate.of(2023, 11, 13), (Guest) userCatalog.getUsers().get("hi"));
        }

         */

        System.out.println("hi");

        for (String key: userCatalog.getUsers().keySet()){
            System.out.println(key);
        }



        ReservationController reservationController = new ReservationController(bookingCatalog, roomCatalog);

        ProfileController profileController = new ProfileController(userCatalog);

        //LoginController loginController = new LoginController();

        ReservationsController frontReservationsController = new ReservationsController();

        masterController = new MasterController(profileController, reservationController, frontReservationsController);

        new LoginController();




        //roomCatalog.viewAllRooms();

        //bookingCatalog.viewAllBookings();

        /*
        for (Map.Entry<String, Room> entry : roomCatalog.getRooms().entrySet()){
            Room room = entry.getValue();
            bookingCatalog.createBooking(room, LocalDate.of(2023, 10, 20), LocalDate.of(2023, 10, 30));
        }
        */


        /*
        boolean loggedIn = false;



        // application loop
        while(true) {

            User user = profileController.getCredentials(loggedIn);

            if (user instanceof Guest) {
                System.out.println("Please select one: EDIT PROFILE, MAKE RESERVATION, or EDIT RESERVATION");
                String userInput = scanner.nextLine().toUpperCase();
                if (userInput.equals("EDIT PROFILE")){
                    profileController.modifyUserAccount(user);
                } else if (userInput.equals("MAKE RESERVATION")){
                    reservationController.makeReservation((Guest) user);
                }
                user.modifyAccount();
                saveUsers(users);
            }
            else if (user instanceof Admin){
                Clerk clerkToAdd = ((Admin)user).createClerkAccount("1234");
                users.put(clerkToAdd.getUserName(), clerkToAdd);
                saveUsers(users);
            }
            else if (user instanceof Clerk){
                String choice = ((Clerk) user).optionSelect();

                if (choice.equalsIgnoreCase("PROFILE")){
                    user.modifyAccount();
                } else if (choice.equalsIgnoreCase("ROOM")){
                    roomCatalog.modifyRoom();
                    saveRoomCatalog(roomCatalog);
                }
            }

            user = null;
            System.out.println("Successfully Logged Out! Goodbye!");


        }

         */


    }

    public static Guest signUp() {

        Guest guest;

        System.out.println("Please, type your first and last name. Then press enter.");
        String name = scanner.nextLine();

        System.out.println("Please, type a username. Then press enter.");
        String username = scanner.nextLine();

        System.out.println("Please, enter a password. Then press enter.");
        String password = scanner.nextLine();

        guest = new Guest(name, username, password);

        return guest;
    }

    public static User logIn() {

        User user;
        String input_password;
        String password;

        System.out.println("Please, type your username. Then press enter.");
        String username = scanner.nextLine();

        while (!users.containsKey(username)) {
            System.out.println("User Name Invalid! Please, try again.");
            username = scanner.nextLine();
        }
        user = users.get(username);

        password = user.getPassword();
        while (true) {
            System.out.println("What is your password?");
            input_password = scanner.nextLine();

            if (input_password.equals(password)) break;
            else System.out.println("Invalid Password! Please, try again.");
        }

        System.out.println("Logged in as a(n) " + user.getStatus());

        return user;
    }

    public static void saveRoomCatalog(RoomCatalog roomCatalog) throws IOException {
        File roomFile = new File("roomFile.ser");
        try (FileOutputStream fileOut = new FileOutputStream(roomFile);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(roomCatalog);
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception details for debugging
            // Handle the exception as needed
        }
    }

    public static RoomCatalog loadRoomCatalog() throws IOException, ClassNotFoundException {

        RoomCatalog roomCat = null;
        try (FileInputStream fileIn = new FileInputStream("roomFile.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            roomCat = (RoomCatalog) objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Print the exception details for debugging
        }
        return roomCat;
    }

    public static BookingCatalog loadBookingCatalog() throws IOException, ClassNotFoundException {

        BookingCatalog bookCat = null;
        try (FileInputStream fileIn = new FileInputStream("bookingFile.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            bookCat = (BookingCatalog) objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Print the exception details for debugging
        }

        return bookCat;
    }

    public static void saveUsers(HashMap<String, User> userMap) throws IOException {
        File userFile = new File("userFile.ser");
        try (FileOutputStream fileOut = new FileOutputStream(userFile);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception details for debugging
        }
    }

    public static UserCatalog loadUserCatalog() throws IOException, ClassNotFoundException {

        UserCatalog userCatalog = null;
        try (FileInputStream fileIn = new FileInputStream("userFile.ser");
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            userCatalog = (UserCatalog) objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Print the exception details for debugging
            // Handle the exception as needed
        }
        return userCatalog;
    }


}