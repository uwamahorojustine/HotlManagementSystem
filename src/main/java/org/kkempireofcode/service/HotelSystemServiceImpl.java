package org.kkempireofcode.service;

import org.kkempireofcode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
@Service
@Transactional
public class HotelSystemServiceImpl implements HotelSystemService {
    @Autowired
    private HotelSystemDAO hotelSystemDAO;

    public User getUSer(String username, String password) {

        return hotelSystemDAO.getUser( username,password);
    }

    public List<User> getAllUsers() {
        return hotelSystemDAO.getAllUsers();
    }

    @Override
    public Room getRoom(String description, Double price, String status) {
        return hotelSystemDAO.getRoom(description,price,status);
    }

    @Override
    public List<Room> getAllRooms() {
        return hotelSystemDAO.getAllRooms();
    }

    @Override
    public void addUser(User user) {
  hotelSystemDAO.addUser(user);
    }

    @Override
    public User getUSer(int id) {

        return hotelSystemDAO.getUSer(id);
    }

    @Override
    public void addRoom(Room room) {
        hotelSystemDAO.addRoom(room);
    }

    @Override
    public Room getRoom(int id) {

        return hotelSystemDAO.getRoom(id);
    }

    @Override
    public void editUser(User user) {
        hotelSystemDAO.editUser(user);
    }

    @Override
    public void removeUser(User user) {
        hotelSystemDAO.removeUser(user);
    }

    @Override
    public void makeReservation(Reservation reservation) {
       hotelSystemDAO.makeReservation(reservation);
    }



    @Override
    public List<Reservation> getAllReservation() {
        return hotelSystemDAO.getAllReservation();
    }

    @Override
    public Reservation getReservation(int id) {
        return hotelSystemDAO.getReservation(id);
    }

    @Override
    public List<Reservation> getAllPandingReservation() {
        return hotelSystemDAO.getAllPandingReservation();
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        return hotelSystemDAO.getAllAvailableRooms();
    }

    @Override
    public void makebooking(Booking booking) {
    hotelSystemDAO.makebooking(booking);
    }

    @Override
    public List<Reservation> getAllReservationsFromDate(Date dateFrom) {
        return hotelSystemDAO.getAllReservationsFromDate(dateFrom);
    }

    @Override
    public List<Booking> getAllBookingsFromDate(Date dateFrom) {
        return hotelSystemDAO.getAllBookingsFromDate(dateFrom);    }

    @Override
    public Booking getBooking(int id) {
        return hotelSystemDAO.getBooking(id);
    }

    @Override
    public void addBooking(Booking booking) {
        hotelSystemDAO.addBooking(booking);
    }

    @Override
    public List<Booking> getAllBookingsbyStartDateAndEndDate(Date startDate,Date endDate) {
        return hotelSystemDAO.getAllBookingsFromDate(startDate,endDate);    }

    @Override
    public void addItem(Item item) {
hotelSystemDAO.addItem(item);
    }

    @Override
    public List<Item> getAllItem() {
        return hotelSystemDAO.getAllItem();    }


}
