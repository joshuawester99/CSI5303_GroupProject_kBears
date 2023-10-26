
package driver;

import java.util.Scanner;

public class User {
    	
	protected String name;
	protected String username;
	protected String password;
	
	protected enum modificationOption { NAME, USERNAME, PASSWORD, EXIT }
	
    public User(){
        this.name = "None";
    }
    
    public User(String name) {
        this.name = name;
        this.username = "default";
        this.password = "default";

    }

    public User(String name, String userName, String password){
        this.name = name;
        this.username = userName;
        this.password = password;
    }
	
	// the only people who need to be able to sign up are the customers...
	// everybody else should have an account made separately? Otherwise, how do we specify when they sign up.

	
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
	
	
	 public String getName() {
	        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
