package driver;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking implements Serializable {

    Room room;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate bookingDate;
    LocalDate paidDate;
    Guest guest;
    Boolean checkedIn = false;
    Boolean checkedOut = false;
    Boolean paid = false;
    Boolean canceledPaid = false;
    long totalRate = 0;
    String paymentInfo = "";

    public Booking(Room room, LocalDate startDate, LocalDate endDate, Guest guest, long totalRate) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.bookingDate = LocalDate.now();
        this.paymentInfo = guest.getCreditCard();
        this.totalRate = totalRate;
    }

    public Booking(){
        this.bookingDate = LocalDate.now();
    }

    public Booking(Booking other){
        this.room = other.getRoom();
        this.startDate = other.getStartDate();
        this.endDate = other.getEndDate();
        this.guest = other.getGuest();
        this.bookingDate = other.getBookingDate();
        this.paidDate = other.getPaidDate();
        this.checkedIn = other.getCheckedIn();
        this.checkedOut = other.getCheckedOut();
        this.paid = other.getPaid();
        this.totalRate = other.getTotalRate();
        this.paymentInfo = other.getPaymentInfo();
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

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }


    public long getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(long totalRate) {
        this.totalRate = totalRate;
    }

    public void setTotalRateWithDates(LocalDate newStartDate, LocalDate newEndDate) {
        long newDays = Math.abs(newEndDate.until(newStartDate, ChronoUnit.DAYS));
        long newRate = this.getRoom().getRate() * newDays;
        setTotalRate(newRate);
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Boolean getCanceledPaid() {
        return canceledPaid;
    }

    public void setCanceledPaid(Boolean canceledPaid) {
        this.canceledPaid = canceledPaid;
    }
}
