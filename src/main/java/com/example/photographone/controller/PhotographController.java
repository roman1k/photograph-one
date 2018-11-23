package com.example.photographone.controller;


import com.example.photographone.DAO.PhotographDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.Photograph;
import com.example.photographone.models.Sex;
import com.example.photographone.models.User;
import com.example.photographone.service.PhotographService;
import com.example.photographone.service.implem.PhotographServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
public class PhotographController {
    PhotographDAO photographDAO;
    UserDAO userDAO;

    @PostMapping("/saveFirstPhotographer")
    public String savefirstphotograph(
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
            @AuthenticationPrincipal
            ){

            userDAO.getOne(userDetails.);
            Photograph photograph =  userDAO.findByUsername(userDetails.getUsername());
            photograph.get
          //  principal.getName();

        // .getOne(userDAO.findByUsername(principal.getName()));  // userDAO.findByUsername(principal.getName());






    }





}
