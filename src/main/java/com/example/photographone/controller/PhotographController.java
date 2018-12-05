package com.example.photographone.controller;


import com.example.photographone.DAO.PhotographDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.Photograph;
import com.example.photographone.models.Sex;
import com.example.photographone.models.User;
import com.example.photographone.models.UserDepended;
import com.example.photographone.service.PhotographService;
import com.example.photographone.service.implem.PhotographServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
public class PhotographController {
    @Autowired
   private PhotographDAO photographDAO;
    @Autowired
   private UserDAO userDAO;
    @Qualifier("photographServiceImpl")
   private PhotographService photographService;

    @PostMapping("/1")
    public String q(){
        return  "saveFirstPhotographer";
    }






    @PostMapping("/saveFirstPhotographer")
    public String saveFirstPhotographer(
            @RequestParam MultipartFile avatar,
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
            @RequestParam int Sale,
            @RequestParam String nameGallery,
            @RequestParam String photos,
            @AuthenticationPrincipal User user
            ) {
        System.out.println("1");

        Photograph photograph =(Photograph)user.getUserDep();
        System.out.println("2");
         user.setUserDep(photographService.getPhotograph(avatar.getOriginalFilename(),
                firstName, lastName, Age, sex, description, email, number, facebook,
                instagram, city, Sale, nameGallery, photos, photograph));

        System.out.println("3");


        return "next";
    }
}
