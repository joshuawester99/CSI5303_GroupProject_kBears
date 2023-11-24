package driver;

import java.io.Serializable;
import java.time.LocalDate;

public class Booking implements Serializable {

    Room room;
    LocalDate startDate;
    LocalDate endDate;
    Guest guest;

    public Booking(Room room, LocalDate startDate, LocalDate endDate, Guest guest) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
    }

    public Booking(){

    }

    public Booking(Booking other){
        this.room = other.getRoom();
        this.startDate = other.getStartDate();
        this.endDate = other.getEndDate();
        this.guest = other.getGuest();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
