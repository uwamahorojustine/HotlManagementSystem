package org.kkempireofcode.controller;

import org.kkempireofcode.model.Reservation;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class managerReservationsController {
    @Autowired
    private HotelSystemService service;

    // go to the adduser.jsp page which has a form to create user
    @RequestMapping(value = "/reservation",method = RequestMethod.GET)
    public ModelAndView showManageUsePage(ModelAndView model,HttpServletRequest request){
        model.addObject("roomId",request.getParameter("roomId"));
        model.setViewName("reservation");
        return model;
    }

    // Method to create user and save him/her in database
    @RequestMapping(value = "reservation",method = RequestMethod.POST)
    public ModelAndView reservation(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {
//
//        if(!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }
        //Get values from form (on addUser.jsp)
        String name=request.getParameter("names");
        String othername=request.getParameter("othernames").trim();
        if (!othername.equals("")&& othername != null){
            name =othername;
        }
        String tel=request.getParameter("Tel");
        String email=request.getParameter("email");
        int roomId=Integer.parseInt(request.getParameter("roomId"));
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


        // Create new user by using values from form
        Reservation reservation=new Reservation();
        reservation.setNames(name);
        reservation.setTel(tel);
        reservation.setRoomId(roomId);
        reservation.setEmail(email);
        reservation.setStartDate(new java.sql.Date(sdf.parse(String.valueOf(startDate)).getTime()));
        reservation.setEndDate(new java.sql.Date(sdf.parse(String.valueOf(endDate)).getTime()));
        reservation.setResStatus("Pending");



        //save user
        service.makeReservation(reservation);

        //set redirect page
        model.addObject("allrooms",service.getAllRooms());
        model.setViewName("home");

        // go to the redirect page
        return model;
    }

//    public boolean isAuthenticated(HttpSession session){
//       if(session.getAttribute("Izina")!=null)
//           return true;
//        return false;
//}

}
