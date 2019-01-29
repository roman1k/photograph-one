package com.example.photographone.controller;

import com.example.photographone.DAO.CityDAO;
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
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private CityDAO cityDAO;


    @PostMapping("/newPhotograph")
    public String newPhotograph(User user, Contact contact) {
        userService.savePhotograph(user, contact);
        return "redirect:/";
    }

    @PostMapping("/newUser")
    public String newUser(User user, Contact contact) {
        userService.saveUser(user, contact);
        return "redirect:/";
    }

    @PostMapping("/successURL")
    private String saveUser(@AuthenticationPrincipal User user, Model model) {
        if (user.getUserDep() instanceof Photograph) {
            model.addAttribute("photograph", user);
            return "redirect:/photograph/MyPage";
        } else if (user.getUserDep() instanceof Costumer) {
            model.addAttribute("costumer", user);
            return "redirect:/user/MyPage";
        } else
            return "redirect:/admin/" + user.getUsername();
    }


}






