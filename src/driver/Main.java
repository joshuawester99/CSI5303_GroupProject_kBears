
package driver;

import loginandsignup.LoginController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Room> rooms = new ArrayList<Room>();
    static HashMap<String, User> users = new HashMap<String, User>();
    static int guestIncrement = 1;
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
        new LoginController();
    	
//        users.put("admin", new Admin());
//              
//        // application loop
//        while(true) {
//        	
//            User user = getCredentials();
//            
//            if (user instanceof Guest) {
//            	user.modifyAccount();	
//            }
//            else {
//            	// create Admin and Clerk functionality.
//            }
//            
//            // if exit clause, break and close.
//            scanner.close();
//        }
    }
    
    public static User getCredentials() {

        User user = null;
        String user_status;
        Boolean loggedIn = false;

        while (!loggedIn) {

            System.out.println("Please choose Create Account or Log In");
            user_status = scanner.nextLine();

                if (user_status.equals("Create Account")) {

                        user = signUp(); // not sure if this makes user a guest or not...
                    users.put(user.username, (Guest) user); // only guests will use the sign up functionality
                    guestIncrement += 1; // is this for giving guests an ID?
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

        return user;
    }
}
