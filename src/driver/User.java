package driver;

import java.util.Scanner;

public class User {
	
	protected String name;
	protected String username;
	protected String password;
	
	protected enum modificationOption { NAME, USERNAME, PASSWORD, EXIT }
	
	public User() {
		
	}
	
	// the only people who need to be able to sign up are the customers...
	// everybody else should have an account made separately? Otherwise, how do we specify when they sign up.
	
	public void signUp() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please, type your first and last name. "
				+ "Then press enter");
		name = scan.nextLine();
		
		System.out.println("Please, type a username. "
				+ "Then press enter");
		username = scan.nextLine();
		
		System.out.println("Please, enter a password."
				+ "Then press enter");
		password = scan.nextLine();
		
		scan.close();
		
		return;
	}
	
	public void logIn() {
		
		// does not do it
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please, type your username. "
				+ "Then press enter");
		username = scan.nextLine();
		
		System.out.println("Please, enter your password. "
				+ "Then press enter");
		password = scan.nextLine();
		
		scan.close();
		
		return;
				
	}
	
	protected void modifyAccount() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, enter the attribute you want to modify: either 'name' or 'username'. "
				+ "\nType 'exit' to close.");
		String userInput = scan.next().toUpperCase();
		modificationOption choice = modificationOption.valueOf(userInput);
		
		switch (choice) {
			case NAME:
				modifyName();
				break;
			case USERNAME:
				modifyUsername();
				break;
			case EXIT:
				break;
			default:
				System.out.println("Please, enter the attribute you want to modify: either 'name' or 'username'. "
						+ "\nType 'exit' to close.");
		}
		
		scan.close();
		return;
	}
	
	protected void modifyName() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You current name is: " + name);
		System.out.println("Please, type a new name: ");
		name = scan.next();
		System.out.println("Your new name is: " + name);
		
		scan.close();
		return;
	}
	
	protected void modifyUsername() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You current username is: " + username);
		System.out.println("Please, type a new username: ");
		username = scan.next();
		System.out.println("Your new name is: " + username);
		
		scan.close();
		return;
	}
	
}
