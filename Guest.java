package driver;

public class Guest extends User{

    private int guestID;
    private String creditCard;
    private Boolean corporateGuest;

    public Guest(String name, int guestID, String creditCard, Boolean corporateGuest) {
        super(name);
        this.guestID = guestID;
        this.creditCard = creditCard;
        this.corporateGuest = corporateGuest;
    }

    public Guest(String name, String userName, String password, int guestID){
        super(name, userName, password);
        this.guestID = guestID;
    }
    
    public Guest(String name, String username, String password) {
    	super(name, username, password);
    }
    
    public Guest(String name, int guestID) {
        super(name);
        this.guestID = guestID;
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
