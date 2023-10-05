package driver;

public class Admin extends User {
	
	// there is only going to be one Admin, so nobody would make a new one. We just start with one.
	
	// log in to the system using a username and a password.
	// create a hotel clerk account which contains a username and a default password.
	
	// Future Requirement: The admin user should be able to reset the user account password.
	
	public void createClerkAccount() {
		User clerk = new Clerk();
		clerk.signUp();
		return;
	}
}
