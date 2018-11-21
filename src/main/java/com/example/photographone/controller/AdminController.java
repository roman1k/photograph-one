package com.example.photographone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

@GetMapping("/userFound")
public String userFound(){

return "admin";
}

@GetMapping("/allCities")
public String allCities(){

return "admin";
}

@GetMapping("/saveCity")
public String saveCity(){

return "admin";
}

}
