package driver;


import loginandsignup.*;
import reservations_interface.*;
import room_interface.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MasterController {

    private static MasterController instance;
    ProfileController profileController;
    ReservationController reservationController;
    ReservationsController frontReservationsController;
    LoginController loginController;

    User currentUser = new User();


    public MasterController(ProfileController profileController, ReservationController reservationController, ReservationsController frontReservationsController) {
        this.profileController = profileController;
        this.reservationController = reservationController;
        this.frontReservationsController = frontReservationsController;

    }

    public void setCurrentUser (String username){
        currentUser = profileController.userCatalog.getUsers().get(username);
    }

    public MasterController() {

    }

    public static synchronized MasterController getInstance() {
        if (instance == null){
            instance = new MasterController();
        }
        return instance;
    }

    public void createGuestAccount(String name, String username, String password) throws IOException {
        profileController.createGuestAccount(name, username, password);
    }

    public boolean checkForUsername (String username){
        return profileController.checkForUsername(username);
    }

    public boolean checkForPassword (String username, String password){
        return profileController.checkForPassword(username, password);
    }

    public ArrayList<Room> getAllRooms(){
        return reservationController.getAllRooms();
    }

    public ArrayList<Room> getFilteredRooms(String smoking, String bedType, String bedNumber, String quality){
        return reservationController.getFilteredRooms(smoking, bedType, bedNumber, quality);
    }

    public ArrayList<Room> getAvailableRooms (ArrayList<Room> roomList, LocalDate startDate, LocalDate endDate){
        return reservationController.getAvailableRooms(roomList, startDate, endDate);
    }

    public Room getRoom(String roomNumber){
        return reservationController.roomCatalog.getRooms().get(roomNumber);
    }

    public void bookRoom(Room room, LocalDate startDate, LocalDate endDate, Guest guest) throws IOException {
        reservationController.bookingCatalog.createBooking(room, startDate, endDate, guest);
    }

    public void modifyProfile(User user, String newName, String newUsername, String newPassword) throws IOException {

        User oldUser = user;
        Guest oldGuest = new Guest();

        if (oldUser instanceof Guest){
            System.out.println("In MC, olduser username is " + oldUser.getUserName());
            oldGuest = (Guest) oldUser;
        }


        String oldUsername = oldUser.getUserName();
        currentUser = profileController.modifyProfile(user, newName, newUsername, newPassword, oldUsername);
        System.out.println("In MC, olduser username is " + oldUser.getUserName());
        if (oldUser instanceof Guest){
            adjustGuestBooking(oldGuest, (Guest) currentUser);
        }

    }

    public void adjustGuestBooking (Guest oldUser, Guest newUser) throws IOException {
        reservationController.adjustGuestBooking(oldUser, newUser);
    }

    public void createClerkAccount(String username) throws IOException {
        profileController.createClerkAccount(username);
    }

    public String checkUserInstance () {
        if (currentUser instanceof Admin){
            return "Admin";
        } else if (currentUser instanceof Clerk){
            return "Clerk";
        } else if (currentUser instanceof Guest) {
            return "Guest";
        } else {
            return "None";
        }
    }

    public ArrayList<Booking> getGuestBookings (User guest){
        return reservationController.getGuestBookings(guest);
    }

    public void deleteBooking (Booking booking) throws IOException {
        reservationController.deleteBooking(booking);
    }

    public boolean checkNewAvailability(Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate){
        return reservationController.checkNewAvailability(oldBooking, newStartDate, newEndDate);
    }

    public Booking adjustBooking(Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate) throws IOException {
        return reservationController.adjustBooking(oldBooking, newStartDate, newEndDate);
    }

    public void modifyRoom(Room oldRoom, String newSmoking, String newQuality, String newBedType, String newBedNumber) throws IOException {
        reservationController.modifyRoom(oldRoom, newSmoking, newQuality, newBedType, newBedNumber);
    }

    public ArrayList<Clerk> getClerks() {
        return profileController.getClerks();
    }

    public ArrayList<User> getAllUsers() {
        return profileController.getAllUsers();
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
