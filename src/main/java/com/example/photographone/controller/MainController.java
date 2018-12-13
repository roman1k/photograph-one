package com.example.photographone.controller;

import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import com.example.photographone.service.implem.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @PostMapping("/newUser")
    public String newUser(User user, Contact contact){
        userService.saveUser(user,contact);
        return "redirect:/";
    }

    @PostMapping("/successURL")
    private  String saveUser(@AuthenticationPrincipal User user) {
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
        return "redirect:/photographProfile/"+ user.getUsername();
    }
    @PostMapping("/photographProfile/{username}")
    private  void pagePhotograph(@PathVariable String username, Model model, Model model1) {
        User user =(User)userService.loadUserByUsername(username);
        Photograph photograph = (Photograph) user.getUserDep();
        model.addAttribute("user", user);
        model1.addAttribute("photograph", photograph);
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");

    }






}
