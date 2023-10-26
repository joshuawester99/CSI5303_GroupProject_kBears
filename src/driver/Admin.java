package driver;

public class Admin extends User {

    private int adminID = 1;
    private String name;
    private String username;
    private String password;

    public Admin() {
    	this.name = "admin";
    	this.username = "admin";
    	this.password = "admin";
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    // there is only going to be one Admin, so nobody would make a new one. 
 	// Maybe just hard code like above?
    // We just start with one and give it a password.
    
    // need to fix this.
    // create a hotel clerk account which contains a username and a default password.
	public void createClerkAccount(String name, String employeeID) {
		// User clerk = new Clerk(name, employeeID);
		// clerk.signUp();
		return;
	}
}
