package com.example.photographone.controller;


import com.example.photographone.DAO.PhotographDAO;
import com.example.photographone.models.Sex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhotographController {
    PhotographDAO photographDAO;

    @PostMapping("/saveFirstPhotographer")
    public String savefirstphotograph(
            @RequestParam String avatar,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int Age,
            @RequestParam Sex sex,
            @RequestParam String description,
            @RequestParam String email,
            @RequestParam long number,
            @RequestParam String facebook,
            @RequestParam String instagram,
            @RequestParam String city,
            @RequestParam String nameGallery,
            @RequestParam String photos

            ){






    }





}
