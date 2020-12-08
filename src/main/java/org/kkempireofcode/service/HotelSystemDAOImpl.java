package org.kkempireofcode.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.kkempireofcode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Repository
public class HotelSystemDAOImpl implements HotelSystemDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User getUser(String username, String password) {
        User user=null;

        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User");
        List<User> result=(List<User>) qr.list();

        for (User u:result) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)){
                user=u;
                break;
            }
        }
        return user ;
    }

    @Override
    public Room getRoom(String description, Double price, String status) {
        Room room=null;

        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();

        for (Room u:result) {
            if (u.getDescription().equals(description) &&  u.getStatus().equals(status)){
                room=u;
                break;
            }
        }
        return room ;
    }
    @Override
    public List<User> getAllUsers() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User");
        List<User> result=(List<User>) qr.list();
        return result;
    }

    @Override
    public List<Room> getAllRooms() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();
        return result;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUSer(int id) {
        User user=null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User WHERE id="+id);
        List<User> result=(List<User>) qr.list();
        return result.get(0) ;

    }

    @Override
    public void addRoom(Room room) {

        sessionFactory.getCurrentSession().saveOrUpdate(room);
    }

    @Override
    public Room getRoom(int id) {
        Room room=null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room WHERE id="+id);
        List<Room> result=(List<Room>) qr.list();
        return result.get(0) ;
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void removeUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void makeReservation(Reservation reservation) {
            sessionFactory.getCurrentSession().saveOrUpdate(reservation);
            Room room=getRoom(reservation.getRoomId());
            room.setStatus("Reserved");
            addRoom(room);
        }

    @Override
    public List<Reservation> getAllReservation() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation");
        List<Reservation> result=(List<Reservation>) qr.list();
        return result;
    }

    @Override
    public Reservation getReservation(int id) {
        Reservation reservation =null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation WHERE id="+id);
        List<Reservation> result=(List<Reservation>) qr.list();
        return result.get(0) ;
    }

    @Override
    public Booking getBooking(int id) {
        Booking booking=null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking WHERE bookingId="+id);
        List<Booking> result=(List<Booking>) qr.list();
        return result.get(0) ;
    }

    @Override
    public void addBooking(Booking booking) {
        sessionFactory.getCurrentSession().saveOrUpdate(booking);
    }

    @Override
    public List<Booking> getAllBookingsFromDate(Date startDate, Date dateFrom) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking order by roomId");
        List<Booking> result=(List<Booking>) qr.list();
        List<Booking> bookingsAfterDate=new ArrayList<Booking>();
        for (Booking book:result){
            if (book.getStartDate().after(dateFrom)||(book.getStartDate().equals(dateFrom))){
                bookingsAfterDate.add(book);
            }
        }
        return bookingsAfterDate;    }

    @Override
    public List<Reservation> getAllPandingReservation() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation");
        List<Reservation> result=(List<Reservation>) qr.list();
        List<Reservation> PandingReservations= new ArrayList<Reservation>();
        for (Reservation reservation:result){
            if (reservation.getResStatus().equals("Pending")){
                PandingReservations.add(reservation);
            }
        }
        return PandingReservations;
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();
        List<Room> availableRooms=new ArrayList<Room>();
        for (Room room:result){
            if (room.getStatus().equals("Available")||(room.getStatus().equals("Reserved"))){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public void makebooking(Booking booking) {
        sessionFactory.getCurrentSession().saveOrUpdate(booking);
        Room room=getRoom(booking.getRoomId());
        room.setStatus("booked");
        addRoom(room);
    }

    @Override
    public List<Reservation> getAllReservationsFromDate(Date dateFrom) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation order by roomId");
        List<Reservation> result=(List<Reservation>) qr.list();
        List<Reservation> reservationsAfterDate=new ArrayList<Reservation>();
        for (Reservation res:result){
            if (res.getStartDate().after(dateFrom)||(res.getStartDate().equals(dateFrom))){
                reservationsAfterDate.add(res);
            }
        }
        return reservationsAfterDate;
    }

    @Override
    public List<Booking> getAllBookingsbyStartDateAndEndDate(Date startDate, Date endDate) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking order by roomId");
        List<Booking> result=(List<Booking>) qr.list();
        List<Booking> bookingByStartDateAndEndDate=new ArrayList<Booking>();
        for (Booking book:result){
            if (book.getStartDate().after(startDate)||(book.getStartDate().equals(startDate))&&(book.getStartDate().before(endDate)||book.getStartDate().equals(endDate))){
                bookingByStartDateAndEndDate.add(book);
            }
        }
        return bookingByStartDateAndEndDate;    }

    @Override
    public List<Booking> getAllBookingsFromDate(Date dateFrom) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking order by roomId");
        List<Booking> result=(List<Booking>) qr.list();
        List<Booking> bookingsAfterDate=new ArrayList<Booking>();
        for (Booking res:result){
            if (res.getStartDate().after(dateFrom)||(res.getStartDate().equals(dateFrom))){
                bookingsAfterDate.add(res);
            }
        }
        return bookingsAfterDate;    }

    @Override
    public void addItem(Item item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);

    }

    @Override
    public List<Item> getAllItem() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Item");
        List<Item> result=(List<Item>) qr.list();
        return result;    }


}




