package driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ProfileController {

    UserCatalog userCatalog;

    public ProfileController(UserCatalog userCatalog) {
        this.userCatalog = userCatalog;
    }


    // Create a guest
    public void createGuestAccount(String name, String username, String password, Boolean corporate, String creditCard) throws IOException {
        userCatalog.guestSignUp(name, username, password, corporate, creditCard);
    }

    // Create a clerk
    public void createClerkAccount(String username) throws IOException {
        userCatalog.clerkSignUp(username);
    }

    public ArrayList<Clerk> getClerks() {
        return userCatalog.getClerks();
    }

    public ArrayList<User> getAllUsers() {
        return userCatalog.getUserList();
    }


    public boolean checkForUsername(String username){
        return userCatalog.getUsers().containsKey(username);
    }

    public boolean checkIfGuest(String username) {
        return userCatalog.checkIfGuest(username);
    }

    public Guest getGuest(String username) {
        return userCatalog.getGuest(username);
    }

    public boolean checkForPassword(String username, String password){
        return userCatalog.getUsers().get(username).getPassword().equals(password);
    }

    public User modifyProfile(User user, String newName, String newUsername, String newPassword, String oldUsername) throws IOException {
        return userCatalog.modifyProfile(user, newName, newUsername, newPassword, oldUsername);
    }


}
