package com.example.photographone.service;

import com.example.photographone.models.Contact;
import com.example.photographone.models.Search;
import com.example.photographone.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void saveAdmin(User user, Contact contact);
    void savePhotograph(User user, Contact contact);
    void saveUser(User user, Contact contact);
    List<User> selectPhotographs(Search search);

    //boolean activatePhotographer(String code);
    boolean activateUser(String code);
}
