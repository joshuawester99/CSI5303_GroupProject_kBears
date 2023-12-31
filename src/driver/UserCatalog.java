package driver;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserCatalog implements Serializable {

    public HashMap<String, User> users = new HashMap<String, User>();

    // Sign Up guest account
    public Guest guestSignUp(String name, String username, String password, Boolean corporate, String creditCard) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Guest guest;

        guest = new Guest(name, username, password, corporate, creditCard);
        users.put(guest.getUserName(), guest);
        saveUserCatalog();

        return guest;
    }

    // Sign Up admin account
    public void adminSignUp() throws IOException {
        Admin admin = new Admin();
        users.put(admin.getUserName(), admin);
        saveUserCatalog();
    }

    // Sign Up clerk account
    public void clerkSignUp(String username) throws IOException {
        Clerk clerk = new Clerk (username);
        users.put(username, clerk);
        saveUserCatalog();
    }

    // Sign up clerk account (overload)
    public void clerkSignUp(String name, String username) throws IOException {
        Clerk clerk = new Clerk (name, username);
        users.put(username, clerk);
        saveUserCatalog();
    }

    // Get all clerks
    public ArrayList<Clerk> getClerks() {
        ArrayList<Clerk> clerkList = new ArrayList<Clerk>();
        for (Map.Entry<String, User> entry: users.entrySet()){
            if (entry.getValue() instanceof Clerk){
                clerkList.add((Clerk) entry.getValue());

            }
        }
        return clerkList;
    }

    // Modify a user account
    public void modifyAccount(User currentUser) {

        User updatedUser = new User();

        Scanner scan = new Scanner(System.in);

        if (currentUser instanceof Guest){

            System.out.println("Please, enter the attribute you want to modify: either 'name' or 'username'. "
                    + "\nType 'exit' to close.");
            String userInput = scan.nextLine().toUpperCase();
            User.modificationOption choice = User.modificationOption.valueOf(userInput);

            switch (choice) {
                case NAME:
                    updatedUser = modifyName(currentUser);
                    break;
                case USERNAME:
                    updatedUser = modifyUsername(currentUser);
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Please, enter the attribute you want to modify: either 'name' or 'username'. "
                            + "\nType 'exit' to close.");
            }

        }

        if (currentUser instanceof Clerk){

            System.out.println("Please, enter the attribute you want to modify: either 'name', 'username', or 'password'. "
                    + "\nType 'exit' to close.");

            String userInput = scan.nextLine().toUpperCase();
            User.modificationOption choice = User.modificationOption.valueOf(userInput);

            switch (choice) {
                case NAME:
                    updatedUser = modifyName(currentUser);
                    break;
                case USERNAME:
                    updatedUser = modifyUsername(currentUser);
                    break;
                case PASSWORD:
                    updatedUser = modifyPassword(currentUser);
                case EXIT:
                    break;
                default:
                    System.out.println("Please, enter the attribute you want to modify: either 'name' or 'username'. "
                            + "\nType 'exit' to close.");
            }

        }


        users.replace(currentUser.getUserName(), updatedUser);

    }

    // Modify user's name
    public User modifyName(User currentUser) {

        Scanner scan = new Scanner(System.in);

        System.out.println("You current name is: " + currentUser.getName());
        System.out.println("Please, type a new name: ");
        String name = scan.nextLine();
        currentUser.setName(name);
        users.replace(currentUser.getUserName(), currentUser);
        System.out.println("Your new name is: " + name);

        return currentUser;

    }

    // Modify user's username
    public User modifyUsername(User currentUser) {

        Scanner scan = new Scanner(System.in);

        System.out.println("You current username is: " + currentUser.getUserName());
        System.out.println("Please, type a new username: ");
        String username = scan.nextLine();
        currentUser.setUserName(username);
        users.replace(currentUser.getUserName(), currentUser);
        System.out.println("Your new name is: " + username);

        return currentUser;
    }

    // Modify user's password
    public User modifyPassword(User currentUser) {

        Scanner scan = new Scanner(System.in);

        System.out.println("You current password is: " + currentUser.getPassword());
        System.out.println("Please, type a new password: ");
        String password = scan.nextLine();
        currentUser.setPassword(password);
        users.replace(currentUser.getUserName(), currentUser);
        System.out.println("Your new password is: " + password);

        return currentUser;
    }

    // Modify Profile
    public User modifyProfile(User user, String newName, String newUsername, String newPassword, String oldUsername) throws IOException {

        User oldUser = new User(user);
        User newUser;
        if (user instanceof Guest){
            newUser = new Guest((Guest) user);
        } else if (user instanceof Clerk){
            newUser = new Clerk((Clerk) user);
        } else {
            newUser = new User(user);
        }


        if (!newName.equals("")){
            newUser.setName(newName);
        }
        if (!newUsername.equals("")){
            newUser.setUserName(newUsername);
        }
        if (!newPassword.equals("")){
            newUser.setPassword(newPassword);
        }

        System.out.println(oldUser.getUserName());
        System.out.println(oldUsername);
        System.out.println(newUser.getUserName());
        users.remove(oldUsername);
        users.put(newUser.getUserName(), newUser);

        saveUserCatalog();

        return newUser;
    }

    // Save catalog
    public void saveUserCatalog() throws IOException {
        File userFile = new File("userFile.ser");
        FileOutputStream fileOut = new FileOutputStream(userFile);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(this);
        objOut.close();
        fileOut.close();
    }

    // Get list of users
    public ArrayList<User> getUserList() {
        ArrayList<User> userList = new ArrayList<User>();
        for (Map.Entry<String, User> entry: users.entrySet()){
            userList.add(entry.getValue());
        }
        return userList;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public boolean checkIfGuest(String username){
        return (users.get(username) instanceof Guest);
    }

    public Guest getGuest(String username){
        return (Guest) users.get(username);
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }
}
