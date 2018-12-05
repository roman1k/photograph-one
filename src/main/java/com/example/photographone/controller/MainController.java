package com.example.photographone.controller;

import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.Contact;
import com.example.photographone.models.Costumer;
import com.example.photographone.models.Role;
import com.example.photographone.models.User;
import com.example.photographone.service.implem.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URLEncoder;

@Controller
public class MainController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CostumerDAO costumerDAO;
    @Autowired
    private ContactDAO contactDAO;

    @PostMapping("/saveUser")
    public String save(User user, Model model){
        userService.save(user);
        model.addAttribute("user", user);
    return  "login";
    }

    @PostMapping("/successURL")
    private  String saveUser( ) {
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
        return "next";
    }


}
