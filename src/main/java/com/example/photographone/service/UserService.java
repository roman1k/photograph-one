package com.example.photographone.service;

import com.example.photographone.models.Contact;
import com.example.photographone.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void savePhotograph(User user, Contact contact);
    void saveUser(User user, Contact contact);
    void saveAdmin(User user, Contact contact);
}
