package com.example.photographone.controller;

import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.components.UserValidator;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import com.example.photographone.service.implem.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/newPhotograph")
    public  String mainP (Model model){
        return "index";
    }


    @PostMapping("/newPhotograph")
    public String newPhotograph(User user,
                                Contact contact,
                                BindingResult bindingResult,
                                Model model
    ){
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {

            String complexError="";
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error:allErrors) {
                String defaultMessage = error.getDefaultMessage();
                complexError += defaultMessage+" ";

            }

            model.addAttribute("presented", true);
            model.addAttribute("message", complexError);
            return "index";
        }
        userService.savePhotograph(user,contact);
        return "redirect:/newPhotograph";
    }

    @PostMapping("/newUser")
    public String newUser(User user,
                          Contact contact,
                          BindingResult bindingResult,
                          Model model){
        userService.saveUser(user,contact);
        return "redirect:/";
    }

    @PostMapping("/successURL")
    private  String transition(@AuthenticationPrincipal User user) {
        if (user.getUserDep()instanceof Photograph){
        return "redirect:/photographProfile";}
        else if (user.getUserDep()instanceof Costumer && user.getRole()==Role.ROLE_COSTUMER){
            return "costomer";
        }
        else {
            return "adminn";
        }}}