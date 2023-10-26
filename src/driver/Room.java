package driver;
public class Room {

    private String roomNumber;
    private Boolean smoking;
    private String bedType;
    private int bedNumber;
    private String quality;

    public Room(String roomNumber, Boolean smoking, String bedType, int bedNumber, String quality) {
        this.roomNumber = roomNumber;
        this.smoking = smoking;
        this.bedType = bedType;
        this.bedNumber = bedNumber;
        this.quality = quality;
    }

    public Room(){
        this.roomNumber = "none";
        this.smoking = false;
        this.bedType = "none";
        this.bedNumber = 0;
        this.quality = "none";
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



}
