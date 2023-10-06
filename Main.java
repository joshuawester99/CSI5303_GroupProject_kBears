package driver;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    static ArrayList<Room> rooms = new ArrayList<Room>();
    static HashMap<String, User> users = new HashMap<String, User>();
    static int guestIncrement = 1;
    
    static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {

        Room room1 = new Room("1A", false, "Queen", 2, "economy");
        Room room2 = new Room("1B", false, "King", 1, "comfort");
        Room room3 = new Room("1C", false, "King", 1, "executive");
        Room room4 = new Room("2A", true, "Twin", 2, "economy");
        Room room5 = new Room("2B", true, "Queen", 2, "comfort");

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        users.put("admin", new Admin());
        
        // application loop
        while(true) {
        	
        	User user = getCredentials();
            
            if (user instanceof Guest) {
            	user.modifyAccount();	
            }
            else {
            	// create Admin and Clerk functionality.
            }
            
            // if exit clause, break and close.
            scanner.close();
        }
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