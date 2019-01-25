package com.example.photographone.controller;

import com.example.photographone.DAO.CityDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminRestController {
    @Autowired
    UserService userService;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

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
    public List<User> saveAdmin(@RequestBody User user) {
        user.setUserDep(new UserDepended());
        user.setRole(Role.ROLE_ADMIN);
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        System.out.println("2________________________________");
        userDAO.save(user);
userDAO.save(user);
return userDAO.findAll();
    }
}
