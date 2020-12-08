package org.kkempireofcode.controller;

import org.kkempireofcode.businesslogic.EncriptPassword;
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
public class managerUsersController {
    @Autowired
    private HotelSystemService service;

    // go to the adduser.jsp page which has a form to create user
    @RequestMapping(value = "/user")
    public ModelAndView showManageUsePage(ModelAndView model){
        model.setViewName("addUser");
        return model;
    }

    // Method to create user and save him/her in database
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public ModelAndView addUser(ModelAndView model, HttpServletRequest request, HttpSession session) throws Exception {

        if(!isAuthenticated(session)){
            return new ModelAndView("redirect:/");
        }
        //Get values from form (on addUser.jsp)
        String names=request.getParameter("names");
        String userName=request.getParameter("userName");
        //String password=request.getParameter("password");
        String password= EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(request.getParameter("password")));

        String Role=request.getParameter("role");

        // Create new user by using values from form
        User user=new User();
        user.setNames(names);
        user.setUserName(userName);
        user.setPassword(password);
        user.setRole(Role);

        //save user
        service.addUser(user);

        //set redirect page
        model.addObject("allusers",service.getAllUsers());
        model.setViewName("homeUser");

        // go to the redirect page
        return model;
    }


    @RequestMapping(value="/showEditUser", method = RequestMethod.GET)
    public ModelAndView showEditUser(ModelAndView model, HttpServletRequest request){

        String userId=request.getParameter("id");
        String useName=request.getParameter("useName");
        String names=request.getParameter("names");
        String password=request.getParameter("password");
        String role=request.getParameter("role");

        model.addObject("userId",userId);
        model.addObject("useName",useName);
        model.addObject("names",names);
        model.addObject("password",password);
        model.addObject("role",role);

        model.setViewName("editUser");
        return  model;
    }

    @RequestMapping(value="/editUser", method = RequestMethod.POST)
    public ModelAndView EditUser(ModelAndView model, HttpServletRequest request){

        int  userId=Integer.parseInt(request.getParameter("id"));
        String names=request.getParameter("names");
        String useName=request.getParameter("userName");
        String password=request.getParameter("password");
        String role=request.getParameter("role");

        User user=service.getUSer(userId);
        user.setNames(names);
        user.setUserName(useName);
        user.setPassword(password);
        user.setRole(role);

        service.editUser(user);
        model.addObject("allusers",service.getAllUsers());
        //model.addObject("allStudents",service.getAllRooms());

        model.setViewName("homeUser");
        return  model;
    }

    @RequestMapping(value ="/removeUser",method = RequestMethod.GET)
    public ModelAndView removeUser(ModelAndView model, HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        User user=service.getUSer(id);
        service.removeUser(user);

        model.addObject("allusers",service.getAllUsers());

        model.setViewName("homeUser");
        return model;
    }

    public boolean isAuthenticated(HttpSession session){
       if(session.getAttribute("Izina")!=null)
           return true;
        return false;
}

}
