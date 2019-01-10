package com.example.photographone.controller;

import com.example.photographone.DAO.AdminDAO;
import com.example.photographone.DAO.CityDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.Admin;
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
    AdminDAO adminDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CityDAO cityDAO;

    @GetMapping("/adminn")
    public String admin(){
        return "adminn";
    }

    @GetMapping("/userFound")
    public String userFound(@RequestParam String username, Model model){
        UserDetails o = userDAO.findByUsername(username);
        model.addAttribute("o",o);
        return "adminn";
    }

    @GetMapping("/allCities")
    public String allCities(Model model){
        List<City> cities = cityDAO.findAll();
        model.addAttribute("cities",cities);
        return "adminn";
    }

    @PostMapping("/saveCity")
    public String saveCity(@RequestParam String nameCity){
        System.out.println("1");
        City city = new City(nameCity);
        System.out.println("1");

        cityDAO.save(city);
        System.out.println("1");

        return "redirect:/";
    }
@PostMapping("/addAdmin")
public String addAdmin (
        @RequestParam String loginAdmin,
        @RequestParam String passwordAdmin,
        @RequestParam String emailAdmin)
{
    Admin admin = new Admin(loginAdmin,passwordAdmin,emailAdmin);
        adminDAO.save(admin);
    return "redirect:/";
}
}