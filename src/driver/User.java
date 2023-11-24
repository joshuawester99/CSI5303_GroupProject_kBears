package driver;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {

    protected String name;
    protected String username;
    protected String password;



    protected String status;

    protected enum modificationOption { NAME, USERNAME, PASSWORD, EXIT }

    public User(){
        this.name = "None";
    }

    public User(String name) {
        this.name = name;
        this.username = "default";
        this.password = "default";

    }

    public User (String name, String username){
        this.name = name;
        this.username = username;
        this.password = "default";

    }

    public User(String name, String userName, String password){
        this.name = name;
        this.username = userName;
        this.password = password;
    }

    public User(String name, String userName, String password, String status){
        this.name = name;
        this.username = userName;
        this.password = password;
        this.status = status;
    }

    public User (User other){
        this.name = other.name;
        this.username = other.username;
        this.password = other.password;
        this.status = other.status;

    }

    // the only people who need to be able to sign up are the customers...
    // everybody else should have an account made separately? Otherwise, how do we specify when they sign up.


    protected void modifyAccount() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter the attribute you want to modify: either 'name' or 'username'. "
                + "\nType 'exit' to close.");
        String userInput = scan.nextLine().toUpperCase();
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

        return;
    }

    protected void modifyName() {

        Scanner scan = new Scanner(System.in);

        System.out.println("You current name is: " + name);
        System.out.println("Please, type a new name: ");
        name = scan.nextLine();
        System.out.println("Your new name is: " + name);

        return;
    }

    protected void modifyUsername() {

        Scanner scan = new Scanner(System.in);

        System.out.println("You current username is: " + username);
        System.out.println("Please, type a new username: ");
        username = scan.nextLine();
        System.out.println("Your new name is: " + username);

        return;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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