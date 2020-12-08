package org.kkempireofcode.controller;

import org.kkempireofcode.model.Room;
import org.kkempireofcode.model.User;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class managerRoomsController {
    @Autowired
    private HotelSystemService service;

    // go to the adduser.jsp page which has a form to create user
    @RequestMapping(value = "/Room")
    public ModelAndView showManageUsePage(ModelAndView model){
        model.setViewName("addRoom");
        model.addObject("allrooms",service.getAllRooms());
        return model;
    }

    // Method to create user and save him/her in database
    @RequestMapping(value = "/addRoomAction",method = RequestMethod.POST)
    public ModelAndView addRoom(ModelAndView model, HttpServletRequest request, HttpSession session){

        if(!isAuthenticated(session)){
            return new ModelAndView("redirect:/");
        }
        //Get values from form (on addUser.jsp)
        String description=request.getParameter("description");
        String status=request.getParameter("status");
        Double price= Double.parseDouble(request.getParameter("price"));

        // Create new user by using values from form
        Room room=new Room();
        room.setDescription(description);
        room.setStatus(status);
        room.setPrice(price);


        //save user
        service.addRoom(room);

        //set redirect page
        model.addObject("allrooms",service.getAllRooms());
        model.setViewName("addRoom");

        // go to the redirect page
        return model;
    }

    public boolean isAuthenticated(HttpSession session){
       if(session.getAttribute("Izina")!=null)
           return true;
        return false;
}

}
