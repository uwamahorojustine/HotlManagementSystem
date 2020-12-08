package org.kkempireofcode.service;

import org.kkempireofcode.model.*;

import java.sql.Date;
import java.util.List;

public interface HotelSystemDAO {
    public User getUser(String username, String password);
    public Room getRoom(String description, Double price, String status);
    public List<User> getAllUsers();
    public List<Room> getAllRooms();
    public void addUser(User user);
    public User getUSer(int id);
    public void addRoom(Room room);
    public Room getRoom(int id);
    public void editUser(User user);
    public  void removeUser(User user);
    public void makeReservation(Reservation reservation);
    public List<Reservation> getAllReservation();
    public Reservation getReservation(int id);
    public Booking getBooking(int id);
    public void addBooking(Booking booking);
    public List<Booking> getAllBookingsFromDate(Date startDate, Date dateFrom);
    public List<Reservation> getAllPandingReservation();
    public List<Room> getAllAvailableRooms();
    public void makebooking(Booking booking);
    public List<Reservation> getAllReservationsFromDate(Date dateFrom);
    public List<Booking> getAllBookingsbyStartDateAndEndDate(Date startDate,Date endDate);
    public List<Booking>getAllBookingsFromDate(Date dateFrom);
    public void addItem(Item item);
    public List<Item> getAllItem();

}
