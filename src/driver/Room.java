package driver;

import java.io.Serializable;

public class Room implements Serializable {

    private String roomNumber;
    private Boolean smoking;
    private String bedType;
    private int bedNumber;
    private String quality;
    private String status = "Unoccupied";
    private int rate;


    public Room(String roomNumber, Boolean smoking, String bedType, int bedNumber, String quality, int rate) {
        this.roomNumber = roomNumber;
        this.smoking = smoking;
        this.bedType = bedType;
        this.bedNumber = bedNumber;
        this.quality = quality;
        this.rate = rate;
    }

    public Room(){
        this.roomNumber = "none";
        this.smoking = false;
        this.bedType = "none";
        this.bedNumber = 0;
        this.quality = "none";
    }

    public Room(Room other){
        this.roomNumber = other.getRoomNumber();
        this.quality = other.getQuality();
        this.smoking = other.getSmoking();
        this.bedType = other.getBedType();
        this.bedNumber = other.getBedNumber();
    }
    
    @Override
    public String toString() {
    	String output = "Room Number: " + roomNumber 
    			+ "\nSmoking: " + smoking 
    			+ "\nBed Number: " + bedNumber 
    			+ "\nBed Type: " + bedType 
    			+ "\nQuality: " + quality;
    	return output;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }



}