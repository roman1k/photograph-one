package com.example.photographone.service.implem;


import com.example.photographone.DAO.*;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    MailSender mailSender;
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
            photograph.setActive(true);
            user.setRole(Role.ROLE_PHOTOGRAPH);
            photograph.setActivationCode(UUID.randomUUID().toString());
            photographDAO.save(photograph);
            userDAO.save(user);

        }
        else System.out.println("____________________________________________");

    }

   /* public boolean addUser(User user) {
            User userFromDb = userDAO.findByUsername(user.getUsername());

            if (userFromDb != null) {
                return false;
            }

            user.setActive(true);

            user.setActivationCode(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(Role.ROLE_COSTUMER);

            userDAO.save(user);

            sendMessage(user);

            return true;
    }*/
    @Override
    public boolean saveUser(User user, Contact contact) {

            User userFromDb = userDAO.findByUsername(user.getUsername());

            if (userFromDb != null) {
                return false;
            }

            user.setActive(true);
            user.setRole(Role.ROLE_COSTUMER);
            user.setActivationCode(UUID.randomUUID().toString());

            userDAO.save(user);

            if (!StringUtils.isEmpty(user.getEmail())) {
                String message = String.format(
                        "Hello, %s! \n" +
                                "Welcome to Sweater. Please, visit next link: http://localhost:8080/activate/%s",
                        user.getUsername(),
                        user.getActivationCode()
                );

                mailSender.send(user.getEmail(), "Activation code", message);
            }

            return true;
        }

    @Override
    public List<User> selectPhotographs(Search search) {
        return null;
    }

    public boolean activateUser(String code) {
            User user = userDAO.findByActivationCode(code);

            if (user == null) {
                return false;
            }

            user.setActivationCode(null);

            userDAO.save(user);

            return true;
        }
}