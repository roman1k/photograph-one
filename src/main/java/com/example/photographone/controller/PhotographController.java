package com.example.photographone.controller;

import com.example.photographone.DAO.PhotographDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.Photograph;
import com.example.photographone.models.Sex;
import com.example.photographone.models.User;
import com.example.photographone.service.PhotographService;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/photograph/")
public class PhotographController {
    @Autowired
   private PhotographDAO photographDAO;
    @Autowired
   private UserDAO userDAO;
    @Qualifier("photographServiceImpl")
   private PhotographService photographService;


    @Autowired
    private UserService userService;


    @PostMapping("/saveFirstPhotographer1")
    public String saveFirstPhotographer(
            @RequestParam MultipartFile avatar,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int Age,
            @RequestParam int sage,
            @RequestParam String description,
            @RequestParam String email,
            @RequestParam String number1,
            @RequestParam String facebook,
            @RequestParam String instagram,
            @RequestParam String city,
            @RequestParam int Sale,
            @RequestParam String nameGallery,
            @RequestParam String photos,
            @AuthenticationPrincipal User user
            ) {
        System.out.println("1________________________________");
        Sex sex = Sex.MAN;
                if (sage ==2){
                    sex = Sex.WOMAN;
                }
        long number;
        if(number1.isEmpty()){
                  number = 1;
                }
                else {
            number = Long.parseLong(number1);
        }return "next";
    }
    @GetMapping("/MyPage")
    public String myPage(@AuthenticationPrincipal User user) {

        return "photographProfile";
    }

//    @GetMapping ("{username}")
//    private String pagePhotograph( @PathVariable String username, Model model) {
//        User user = (User) userService.loadUserByUsername(username);
//        Photograph photograph = (Photograph) user.getUserDep();
//        model.addAttribute("user", user);
//        model.addAttribute("photograph", photograph);
//        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
//        return "photographProfile";
//        System.out.println("2___________________________");
//        user.setUserDep(photographService.getPhotograph(avatar.getOriginalFilename(),
//                firstName, lastName, age, sex, description, email, number, facebook,
//                instagram, city, sale, nameGallery, photos, photograph));
//
//        System.out.println("3_________________________");
//
//    }
//        return "next";
//    }
}
