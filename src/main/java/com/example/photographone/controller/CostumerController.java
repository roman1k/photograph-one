package com.example.photographone.controller;

import com.example.photographone.models.Costumer;
import com.example.photographone.models.Photograph;
import com.example.photographone.models.Search;
import com.example.photographone.models.User;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/")
@PreAuthorize("hasAuthority('COSTUMER')")
public class CostumerController {
    @Autowired
    private UserService userService;


    @GetMapping("/MyPage")
       public String myPage(@AuthenticationPrincipal User user){

           return "costumerProfile";


        }

    @GetMapping("{username}")
    private String pageUser(@PathVariable String username, Model model) {
        User user = (User) userService.loadUserByUsername(username);
        Costumer costumer = (Costumer)user.getUserDep();
        model.addAttribute("user", user);
        model.addAttribute("photograph", costumer);
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
        return "costumerProfile";

    }

}
