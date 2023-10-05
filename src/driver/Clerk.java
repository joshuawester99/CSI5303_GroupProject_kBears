package driver;

import java.util.Scanner;

public class Clerk extends User {

	// enter and modify the information of all rooms.
	
	Clerk() {
		password = "default";
	}
	
	@Override
	public void signUp() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please, type your first and last name. "
				+ "Then press enter");
		name = scan.nextLine();
		
		System.out.println("Please, type a username. "
				+ "Then press enter");
		username = scan.nextLine();
		
		scan.close();
		
		return;
	}
	
	@Override
	public void modifyAccount() {
			
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, enter the attribute you want to modify: either 'name', 'username', or 'password'."
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
			case PASSWORD:
				modifyPassword();
				break;
			case EXIT:
				break;
			default:
				System.out.println("Please, enter the attribute you want to modify: either 'name', 'username', or 'password'. "
						+ "\nType 'exit' to close.");
		}
		
		scan.close();
		return;
	}
	
	private void modifyPassword() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You current username is: " + username);
		System.out.println("Please, type a new username: ");
		username = scan.next();
		System.out.println("Your new name is: " + username);
		
		scan.close();
		return;
	}
}
