package com.example.photographone.service.implem;


import com.example.photographone.DAO.*;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RatingDAO ratingDAO;

    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    private PhotographDAO photographDAO;

    @Autowired
    private CostumerDAO costumerDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    @Override
    public void savePhotograph(User user, Contact contact) {
        if(userDAO.findByUsername(user.getUsername())==null){
            contactDAO.save(contact);
            Photograph photograph = new Photograph();
            photograph.setContact(contact);
            Rating rating = new Rating();
            ratingDAO.save(rating);
            photograph.setRating(rating);
            photographDAO.save(photograph);
            user.setUserDep(photograph);
            String encode = passwordEncoder.encode(user.getPassword());
            user.setPassword(encode);
            System.out.println("2________________________________");
            user.setRole(Role.ROLE_PHOTOGRAPH);
            userDAO.save(user);
        }
        else System.out.println("____________________________________________");

    }

    @Override
    public void saveUser(User user, Contact contact) {
        contactDAO.save(contact);
        Costumer costumer = new Costumer();
        costumer.setContact(contact);
        costumerDAO.save(costumer);
        user.setUserDep(costumer);
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        System.out.println("2________________________________");
        user.setRole(Role.ROLE_COSTUMER);
        userDAO.save(user);
    }

    @Override
    public List<User> selectPhotographs(String city, int priceLower, int priceHigher) {
        List<User>  photographs = userDAO.findAll();
        return photographs;

    }

    @Override
    public List<User> allUser() {

        return userDAO.findAll();
    }
}