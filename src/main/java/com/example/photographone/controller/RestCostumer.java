package com.example.photographone.controller;

import antlr.ASTNULLType;
import com.example.photographone.DAO.CityDAO;
import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.DAO.UserDependedDAO;
import com.example.photographone.models.City;
import com.example.photographone.models.Contact;
import com.example.photographone.models.User;
import com.example.photographone.models.UserDepended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestCostumer {

    @Autowired
    UserDependedDAO userDependedDAO;

    @Autowired
    public CityDAO cityDAO;

    @Autowired
    public UserDAO userDAO;

    @Autowired
    public ContactDAO contactDAO;

    @RequestMapping(value = "/selectPhotograph/")
    public @ResponseBody
    List<User> select(City city
    ) {
        System.out.println("________________________________");

        List<User> cities = userDAO.findAll();

        return cities;


    }

}
