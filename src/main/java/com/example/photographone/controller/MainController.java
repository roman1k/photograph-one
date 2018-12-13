package com.example.photographone.controller;

import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.components.UserValidator;
import com.example.photographone.models.Contact;
import com.example.photographone.models.Costumer;
import com.example.photographone.models.Role;
import com.example.photographone.models.User;
import com.example.photographone.service.UserService;
import com.example.photographone.service.implem.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("presented", true);
        return "index";
    }


    @PostMapping("/newPhotograph")
    public String newPhotograph(User user,
                                Contact contact,
                                BindingResult bindingResult,
                                Model model
    ){
        model.addAttribute("presented", false);
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {

            String complexError="";
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error:allErrors) {
                String defaultMessage = error.getDefaultMessage();
                complexError += defaultMessage+" ";

            }

            model.addAttribute("presented", false);
            model.addAttribute("message", complexError);
            return "index";
        }
        userService.savePhotograph(user,contact);
        return "redirect:/";
    }

    @PostMapping("/newUser")
    public String newUser(User user,
                          Contact contact,
                          BindingResult bindingResult){
        userService.saveUser(user,contact);
        return "redirect:/";
    }

    @PostMapping("/successURL")
    private  String saveUser() {
        System.out.println("YOU+++++++++++++++++++++++++++++++++++++++");
        return "redirect:/photographProfile";
    }




}
