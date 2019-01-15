package com.example.photographone.controller;

import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.Contact;
import com.example.photographone.models.Costumer;
import com.example.photographone.models.Role;
import com.example.photographone.models.User;
import com.example.photographone.service.UserService;
import com.example.photographone.service.implem.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URLEncoder;

@Controller
public class MainController {
    @Autowired
    private UserService userService;



    @PostMapping("/newPhotograph")
    public String newPhotograph(User user, Contact contact){
        userService.savePhotograph(user,contact);
        return "redirect:/";
    }

    @PostMapping ("/newUser")
    public String newUser(User user, Contact contact){
        userService.saveUser(user,contact);
        return "redirect:/";
    }

    @PostMapping("/successURL")
    private  String saveUser() {
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
        return "redirect:/photographProfile";
    }


    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){

        boolean isActivated = userService.activatePhotographer(code);

        if (isActivated){
            model.addAttribute("message", "Photograph successfully activated");

        }
        else {
            model.addAttribute("message", "Activation code not found!");
        }

        return "next";

    }



}
