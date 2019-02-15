package com.example.photographone.controller;

import com.example.photographone.DAO.CityDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class AdminRestController {
    @Autowired
    UserService userService;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CostumerDAO costumerDAO;

    @RequestMapping(value = "/saveCity")
    public List<City> saveCity(@RequestBody City city) {
        cityDAO.save(city);
        return cityDAO.findAll();
    }

    @GetMapping("/allCities")
    public List<City> allCities() {
        return cityDAO.findAll();
    }

    @RequestMapping(value = "/saveAdmin")
    public String saveAdmin(@RequestBody User user) {
        System.out.println("1");
        user.setRole(Role.ROLE_ADMIN);
        userService.saveAdmin(user,new Contact());

        System.out.println("2");
        return "adminn";

    }

    @GetMapping("/findUser")
    public List<User> user() {
     return userDAO.findAll();
    }

    @RequestMapping(value = "/deleteUser")
    public  String deleteUser (@RequestBody User user){
        UserDetails byUsername = userDAO.findByUsername(user.getUsername());
        System.out.println(byUsername);
        return "adminn";
    }

}
