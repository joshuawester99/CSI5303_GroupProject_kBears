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

    public User getCurrentUser() {
        return currentUser;
    }
}
