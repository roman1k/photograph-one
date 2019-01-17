package com.example.photographone.controller;

import antlr.ASTNULLType;
import com.example.photographone.DAO.CityDAO;
import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.DAO.UserDependedDAO;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestCostumer {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectPhotograph/")
    public @ResponseBody
    List<User> select(Search search
                      ) {
        System.out.println("________________________________" + search);

        List<User> response = userService.selectPhotographs(search);

        return response;


    }

}
