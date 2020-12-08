package org.kkempireofcode.controller;

import org.kkempireofcode.businesslogic.FileExport;
import org.kkempireofcode.model.Booking;
import org.kkempireofcode.model.Reservation;
import org.kkempireofcode.model.Room;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ReceptionController {
    @Autowired
    private HotelSystemService service;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


    @RequestMapping(value = "/reception")
    public ModelAndView showReceptionPage(ModelAndView model) {

        System.out.println("Pendingggggggggggggggggg: "+service.getAllPandingReservation().size());
        model.addObject("pendingReservations",service.getAllPandingReservation());
        model.addObject("availableRooms",service.getAllAvailableRooms());
        return model;
    }

    @RequestMapping(value = "/checkin")
    public ModelAndView showCheckinPage(ModelAndView model) {
        return model;
    }

    @RequestMapping(value = "/checkout",method =RequestMethod.GET)
    public ModelAndView showCheckoutPage(ModelAndView model,HttpServletRequest request) {
        int bookingId=Integer.parseInt(request.getParameter("bookingId"));
        Booking booking=service.getBooking(bookingId);
        Room room=service.getRoom(booking.getRoomId());
        java.sql.Date checkOutDate = new  java.sql.Date(new Date().getTime());
        int nights =(int) TimeUnit.MILLISECONDS.toDays(checkOutDate.getTime() - booking.getStartDate().getTime());
        double amount = (nights-1)*room.getPrice();

System.out.println("nightmnbvchgfdfghhhhh:"+nights);

        booking.setCheckOutDate(checkOutDate);
        booking.setNights(nights-1);
        booking.setAmount(amount);
        booking.setPaymentDone(true);
        service.addBooking(booking);
model.addObject("booking",booking);
        return model;
    }

    @RequestMapping(value = "/checkStatus", method = RequestMethod.POST)
    public ModelAndView roomStatusPage(ModelAndView model, HttpServletRequest request) throws ParseException {
//        String status = request.getParameter("status");
        java.sql.Date dateFrom = new java.sql.Date(sdf.parse(request.getParameter("dateFrom")).getTime());
        HashMap<Integer, List<Reservation>> roomReservations =new HashMap<Integer, List<Reservation>>();
        List<Reservation> reservationMadeByDateFrom = service.getAllReservationsFromDate(dateFrom);

        for (Reservation res1:reservationMadeByDateFrom) {
            List<Reservation> reservationsByRoom = new ArrayList<Reservation>();
            for (Reservation res2: reservationMadeByDateFrom) {
                if (res1.getRoomId()==res2.getRoomId()){
                    reservationsByRoom.add(res2);
                }
            }
            roomReservations.put(res1.getRoomId(), reservationsByRoom);
        }

        HashMap<Room, List<Reservation>> roomReservationsTemp=new HashMap<Room, List<Reservation>>();
        for (Integer key:roomReservations.keySet()){
            roomReservationsTemp.put(service.getRoom(key), roomReservations.get(key));
        }
        HashMap<Integer, List<Booking>> roomBookings =new HashMap<Integer, List<Booking>>();
        List<Booking> bookingMadeByDateFrom = service.getAllBookingsFromDate(dateFrom);

        for (Booking book1:bookingMadeByDateFrom) {
            List<Booking> bookingsByRoom = new ArrayList<Booking>();
            for (Booking book2: bookingMadeByDateFrom) {
                if (book1.getRoomId()==book2.getRoomId()){
                    bookingsByRoom.add(book2);
                }
            }
            roomBookings.put(book1.getRoomId(), bookingsByRoom);
        }

        HashMap<Room, List<Booking>> roomBookingsTemp=new HashMap<Room, List<Booking>>();
        for (Integer key:roomBookings.keySet()){
            roomBookingsTemp.put(service.getRoom(key), roomBookings.get(key));
        }

        //set redirect page


        model.addObject("pendingReservations",service.getAllPandingReservation());
        model.addObject("availableRooms",service.getAllAvailableRooms());
        model.addObject("roomReservations", roomReservationsTemp);
        model.addObject("roomBookings", roomBookingsTemp);
        model.setViewName("reception");
        return model;


    }
    @RequestMapping(value = "/printbookingbill",method= RequestMethod.POST)
    public ModelAndView printbookingbill(ModelAndView model,HttpServletRequest request,HttpServletResponse response) throws ParseException {
        java.sql.Date startDate = new java.sql.Date(sdf.parse(request.getParameter("startDate")).getTime());
        java.sql.Date endDate = new java.sql.Date(sdf.parse(request.getParameter("endDate")).getTime());


        int bookingId = Integer.parseInt(request.getParameter("bookingId"));

        Booking booking = service.getBooking(bookingId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String filename = "bookingBill" + sdf.format(new Date())+ ".pdf";
        FileExport.printBill(request, response, booking, filename);
        return model;

    }
    @RequestMapping (value = "/report")
    public ModelAndView showReportForm(ModelAndView model) {

        return model;
    }
    @RequestMapping (value = "/reportAction",method = RequestMethod.POST)
    //public ModelAndView runReport(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {
        public ModelAndView runReport(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {
        java.sql.Date startDate= new java.sql.Date(sdf.parse(request.getParameter("StartDate")).getTime());
        java.sql.Date endDate= new java.sql.Date(sdf.parse(request.getParameter("EndDate")).getTime());
        String dataType=request.getParameter("dataType");


       List<Booking> bookings=new ArrayList<Booking>();
        List<Reservation> reservations=new ArrayList<Reservation>();


        if (dataType.equals("booking")){
            bookings=service.getAllBookingsbyStartDateAndEndDate((java.sql.Date) startDate,endDate);
        }
        if (dataType.equals("reservation")){

        }
        model.addObject("bookings",bookings);
        session.setAttribute("bookings",bookings);



        model.setViewName("report");
        return model;
    }
    @RequestMapping(value = "/printBookingReport",method = RequestMethod.POST)
    public ModelAndView printReportAction(ModelAndView model,HttpSession session,HttpServletResponse response){

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String filename="bookingReport"+dateFormatter.format(new Date())+".pdf";
        FileExport.printBookingReport(response,(List<Booking>)session.getAttribute("bookings"),filename.replaceAll("\\s+",""));


        return model;
    }



}
