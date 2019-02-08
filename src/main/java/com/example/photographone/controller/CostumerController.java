package com.example.photographone.controller;

import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class CostumerController {
    @Autowired
    private UserService userService;


    @GetMapping("/MyPage")
       public String myPage(@AuthenticationPrincipal User user, Model model){
        Costumer userDep = (Costumer) user.getUserDep();
        Contact contact = userDep.getContact();
        model.addAttribute("costumer", user);


           return "costumerProfile";


        }

    @GetMapping("{username}")
    private String pageUser(@PathVariable String username, Model model) {
        User user = (User) userService.loadUserByUsername(username);
        Costumer costumer = (Costumer)user.getUserDep();
        model.addAttribute("user", user);
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
        return "costumerProfile";

    }

}
