package org.kkempireofcode.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
@Entity
@Table(name = "booking")
@Transactional
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int bookingId;
        @Column
        private int roomId;
        @Column
        private String names;
        @Column
        private String tel;
        @Column
        private Date startDate;
        @Column
        private Date endDate;
        @Column
        private Date checkOutDate;
        @Column
        private int nights;
        @Column
        private boolean paymentDone;
        @Column
        private double amount;

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public boolean isPaymentDone() {
        return paymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        this.paymentDone = paymentDone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
