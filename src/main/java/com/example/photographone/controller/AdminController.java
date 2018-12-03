package com.example.photographone.controller;

import com.example.photographone.DAO.CityDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserDAO userDAO;
    @Autowired
    CityDAO cityDAO;
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/userFound")
    public String userFound(@RequestParam String username, Model model){
        UserDetails o = userDAO.findByUsername(username);
        model.addAttribute("o",o);
        return "admin";
    }

    @GetMapping("/allCities")
    public String allCities(Model model){
        List<City> cities = cityDAO.findAll();
        model.addAttribute("cities",cities);
        return "admin";
    }

    @GetMapping("/saveCity")
    public String saveCity(@RequestParam String nameCity){
        City city = new City(nameCity);
        cityDAO.save(city);
        return "admin";
    }

}