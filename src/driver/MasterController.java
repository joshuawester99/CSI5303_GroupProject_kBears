package driver;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MasterController {

    private static MasterController instance;
    ProfileController profileController;
    ReservationController reservationController;

    User currentUser = new User();


    // Constructor
    public MasterController(ProfileController profileController, ReservationController reservationController) {
        this.profileController = profileController;
        this.reservationController = reservationController;

    }

    // Set the user of system
    public void setCurrentUser (String username){
        currentUser = profileController.userCatalog.getUsers().get(username);
    }

    // Default Constructor
    public MasterController() {

    }

    public static synchronized MasterController getInstance() {
        if (instance == null){
            instance = new MasterController();
        }
        return instance;
    }

    // Create Account for Guest
    public void createGuestAccount(String name, String username, String password, Boolean corporate, String creditCard) throws IOException {
        profileController.createGuestAccount(name, username, password, corporate, creditCard);
    }

    // Find username
    public boolean checkForUsername (String username){
        return profileController.checkForUsername(username);
    }

    // Check if password match
    public boolean checkForPassword (String username, String password){
        return profileController.checkForPassword(username, password);
    }

    // Get all rooms
    public ArrayList<Room> getAllRooms(){
        return reservationController.getAllRooms();
    }

    // Filter room list
    public ArrayList<Room> getFilteredRooms(String smoking, String bedType, String bedNumber, String quality){
        return reservationController.getFilteredRooms(smoking, bedType, bedNumber, quality);
    }

    // Get rooms that are not booked during requested time frame
    public ArrayList<Room> getAvailableRooms (ArrayList<Room> roomList, LocalDate startDate, LocalDate endDate){
        return reservationController.getAvailableRooms(roomList, startDate, endDate);
    }

    // Get single room
    public Room getRoom(String roomNumber){
        return reservationController.roomCatalog.getRooms().get(roomNumber);
    }

    // Book a room
    public void bookRoom(Room room, LocalDate startDate, LocalDate endDate, Guest guest, long totalRate) throws IOException {
        reservationController.bookingCatalog.createBooking(room, startDate, endDate, guest, totalRate);
    }

    // Modify profile
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

    // Adjust the user of a booking (called when profile modified)
    public void adjustGuestBooking (Guest oldUser, Guest newUser) throws IOException {
        reservationController.adjustGuestBooking(oldUser, newUser);
    }

    // Create a clerk
    public void createClerkAccount(String username) throws IOException {
        profileController.createClerkAccount(username);
    }

    // Check the instance of the current user
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

    // Get the bookings of one or all guests
    public ArrayList<Booking> getGuestBookings (User guest){
        return reservationController.getGuestBookings(guest);
    }

    // Get bookings that have been paid or cancelled (with fee paid)
    public ArrayList<Booking> getPaidBookings (User guest){
        ArrayList<Booking> fullBookingList = reservationController.getGuestBookingsForPayment(guest);
        ArrayList<Booking> paidBookingList = new ArrayList<Booking>();

        for (Booking bookingToCheck : fullBookingList){
            if (bookingToCheck.paid){
                paidBookingList.add(bookingToCheck);
            }
        }
        return paidBookingList;
    }

    // Remove a booking
    public void deleteBooking (Booking booking) throws IOException {
        reservationController.deleteBooking(booking);
    }

    // Check availability of new dates for a booking
    public boolean checkNewAvailability(Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate){
        return reservationController.checkNewAvailability(oldBooking, newStartDate, newEndDate);
    }

    // Adjust the dates of a booking
    public Booking adjustBooking(Booking oldBooking, LocalDate newStartDate, LocalDate newEndDate) throws IOException {
        return reservationController.adjustBooking(oldBooking, newStartDate, newEndDate);
    }

    // Update room details
    public void modifyRoom(Room oldRoom, String newSmoking, String newQuality, String newBedType, String newBedNumber) throws IOException {
        reservationController.modifyRoom(oldRoom, newSmoking, newQuality, newBedType, newBedNumber);
    }

    // Check guest in
    public void checkIn(Booking booking) throws IOException {
        reservationController.checkIn(booking);
    }

    // Check guest out
    public void checkOut(Booking booking) throws IOException {
        reservationController.checkOut(booking);
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

    public boolean checkIfGuest (String username){
        return profileController.checkIfGuest(username);
    }

    public Guest getGuest(String username) {
        return profileController.getGuest(username);
    }

    // Ensure room exists
    public boolean roomExists(String roomNumber){
        return reservationController.roomExists(roomNumber);
    }

}
