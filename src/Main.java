import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    static RoomCatalog roomCatalog = new RoomCatalog();
    static BookingCatalog bookingCatalog = new BookingCatalog();
    static UserCatalog userCatalog = new UserCatalog();
    static HashMap<String, User> users = new HashMap<String, User>();
    static int guestIncrement = 1;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        roomCatalog = loadRoomCatalog();
        bookingCatalog = loadBookingCatalog();
        userCatalog = loadUserCatalog();

        ReservationController reservationController = new ReservationController(bookingCatalog, roomCatalog);

        ProfileController profileController = new ProfileController(userCatalog);

        //roomCatalog.viewAllRooms();

        //bookingCatalog.viewAllBookings();

        /*
        for (Map.Entry<String, Room> entry : roomCatalog.getRooms().entrySet()){
            Room room = entry.getValue();
            bookingCatalog.createBooking(room, LocalDate.of(2023, 10, 20), LocalDate.of(2023, 10, 30));
        }
        */


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


    }

    public static User getCredentials(boolean loggedIn) {

        User user = null;

        while (!loggedIn) {

            System.out.println("Please choose Create Account or Log In");
            String user_status = scanner.nextLine();

            if (user_status.equals("Create Account")) {

                user = signUp();
                users.put(user.username, (Guest) user);
                guestIncrement += 1;
                loggedIn = true;

            } else if (user_status.equals("Log In")) {
                user = logIn();
                loggedIn = true;

            } else System.out.println("Invalid input. Please, try again.");
        }

        System.out.println("Welcome, " + user.getName());
        return user;
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

