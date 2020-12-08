package org.kkempireofcode.controller;

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
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private HotelSystemService service;
    // Method to create user and save him/her in database
    @RequestMapping(value = "checkinAction",method = RequestMethod.POST)
    public ModelAndView addRoom(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {
//
//        if(!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }
        //Get values from form (on addUser.jsp)
        String name=request.getParameter("names");
        String Tel=request.getParameter("tel");
        //String email=request.getParameter("email");
        int roomId=Integer.parseInt(request.getParameter("roomId"));
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


        // Create new user by using values from form
        Booking booking=new Booking();
        booking.setNames(name);
        booking.setRoomId(roomId);
        booking.setTel(Tel);
        //booking.setEmail(email);
        booking.setStartDate(sdf.parse(startDate));
        booking.setEndDate(sdf.parse(endDate));




        //save user
        service.makebooking(booking);

        //set redirect page

        model.addObject("pendingReservations",service.getAllPandingReservation());
        model.addObject("availableRooms",service.getAllAvailableRooms());

        model.setViewName("reception");
        // go to the redirect page
        return model;
    }

//    public boolean isAuthenticated(HttpSession session){
//       if(session.getAttribute("Izina")!=null)
//           return true;
//        return false;
//}

}
