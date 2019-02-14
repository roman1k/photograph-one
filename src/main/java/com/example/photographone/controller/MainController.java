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
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.List;

@Controller
@RestController
public class MainController {
    @Autowired
    private UserService userService;





    @RequestMapping("/newPhotograph")
    public String newPhotograph(User user, Contact contact){
        List<User> all = userService.findAll();
        for  (User user1:all) {
            if (user1.getUsername().equals(user.getUsername())){
                System.out.println("berfhrikgjrtekl");
            }

        }
        userService.savePhotograph(user, contact);
        return "redirect:/";
    }

    @PostMapping("/newUser")
    public String newUser(User user, Contact contact){
        userService.saveUser(user,contact);
        return "redirect:/";
    }

    @PostMapping("/successURL")
    private  String saveUser(@RequestBody User user,
                             @RequestBody Contact contact) {
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
        return "redirect:/photographProfile";
    }




}
