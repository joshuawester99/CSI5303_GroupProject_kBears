package driver;

public class Guest extends User{

    private int guestID;
    private String creditCard;
    private Boolean corporateGuest = false;

    public Guest(String name, int guestID, String creditCard, Boolean corporateGuest) {
        super(name);
        this.guestID = guestID;
        this.creditCard = creditCard;
        this.corporateGuest = corporateGuest;
        this.status = "Guest";
    }

    public Guest(String name, String userName, String password, int guestID){
        super(name, userName, password);
        this.guestID = guestID;
        this.status = "Guest";
    }

    public Guest(String name, String username, String password) {
        super(name, username, password);
        this.status = "Guest";
    }

    public Guest(String name, String username, String password, Boolean corporateGuest, String creditCard) {
        super(name, username, password);
        this.status = "Guest";
        this.corporateGuest = corporateGuest;
        this.creditCard = creditCard;
    }

    public Guest(String name, int guestID) {
        super(name);
        this.guestID = guestID;
        this.status = "Guest";
    }

    public Guest(){

    }

    public Guest(Guest other){
        super(other.name, other.username, other.password);
        this.status = other.status;
    }


    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Boolean getCorporateGuest() {
        return corporateGuest;
    }

    public void setCorporateGuest(Boolean corporateGuest) {
        this.corporateGuest = corporateGuest;
    }

}