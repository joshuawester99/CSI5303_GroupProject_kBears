package driver;

import java.util.Scanner;

public class Clerk extends User {

    private String employeeID;


    public Clerk(String username) {
        super("Clerk", username, "default");
        this.status = "Clerk";
    }

    public Clerk(String name, String username) {
        super(name, username, "default");
        this.status = "Clerk";
    }

    public Clerk (String name, String username, String password){
        super(name, username, password);
        this.status = "Clerk";
    }
    public Clerk(Clerk other){
        super(other.name, other.username, other.password);
        this.status = other.status;
    }

    public String optionSelect(){

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("What would you like to modify? (Please type profile or room)");

            String choice = scan.nextLine();

            if (!choice.equalsIgnoreCase("PROFILE") & !choice.equalsIgnoreCase("ROOM")){
                System.out.println("Invalid Selection!");
                continue;
            }
            return choice;
        }
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

        return;
    }

    private void modifyPassword() {

        Scanner scan = new Scanner(System.in);

        System.out.println("You current password is: " + password);
        System.out.println("Please, type a new password: ");
        password = scan.nextLine();
        System.out.println("Your new password is: " + password);

        return;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
}