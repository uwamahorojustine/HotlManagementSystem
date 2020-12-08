package org.kkempireofcode.controller;

import org.kkempireofcode.businesslogic.EncriptPassword;
import org.kkempireofcode.model.User;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.wda.service.ProjectService;

@Controller
public class LoginController {
    @Autowired
    private HotelSystemService service;

    @RequestMapping(value= "/")
    public ModelAndView viewhomePage (ModelAndView model){
        model.setViewName("home");
        model.addObject("allrooms",service.getAllRooms());


        return model;
    }
    @RequestMapping(value= "/homeUser")
    public ModelAndView viewhomeUserPage (ModelAndView model){
        model.setViewName("homeUser");
        model.addObject("allrooms",service.getAllRooms());


        return model;
    }
    @RequestMapping(value= "/login",method = RequestMethod.POST)
    public ModelAndView loginPage (ModelAndView model, HttpServletRequest request, HttpSession session) throws Exception {
        String username = request.getParameter("username");
        //String password = request.getParameter("password");
        String encriptPassword = EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(request.getParameter("password")));

        User user = service.getUSer(username, encriptPassword);


        if (user != null) {

            model.addObject("allusers",service.getAllUsers());
            model.setViewName("homeUser");
           session.setAttribute("Izina", user.getNames());
            session.setAttribute("userId", user.getId());
            session.setAttribute("role", user.getRole());

        } else {
            model.setViewName("home");
        }
        return model;
    }

    @RequestMapping(value= "/logout")
    public ModelAndView logout (ModelAndView model, HttpSession session){
        session.removeAttribute("userId");
        session.removeAttribute("Izina");
        model.setViewName("home");
        model.addObject("allrooms",service.getAllRooms());
        return model;
    }

    @RequestMapping(value= "/home")
    public ModelAndView showHome (ModelAndView model, HttpSession session){
        model.addObject("allusers",service.getAllUsers());
        model.addObject("allrooms",service.getAllRooms());
model.setViewName("homeUser");
        return model;
    }


}