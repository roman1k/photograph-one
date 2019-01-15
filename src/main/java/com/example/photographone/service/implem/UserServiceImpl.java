package com.example.photographone.service.implem;


import com.example.photographone.DAO.*;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.UUID;

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
    @Autowired
    MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    @Override
    public void savePhotograph(User user, Contact contact) {
        contactDAO.save(contact);
        Photograph photograph = new Photograph();
        photograph.setContact(contact);

        photograph.setActivationCode(UUID.randomUUID().toString());


        Rating rating = new Rating();
        ratingDAO.save(rating);
        photograph.setRating(rating);
        photographDAO.save(photograph);



        String message = String.format(
                "Hello, %s! \n"+
                "You are welcome! Please, visit this link : http://localhost:8080/activate/%s",
                photograph.getFirstName(),
                photograph.getActivationCode()
        );
        if (!StringUtils.isEmpty(photograph.getEmail())){
            mailSender.send(photograph.getEmail(),"Activation code", message);



        }
        user.setUserDep(photograph);
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        System.out.println("2________________________________");
        user.setRole(Role.ROLE_PHOTOGRAPH);
        userDAO.save(user);
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
    public boolean activatePhotographer(String code) {
       Photograph photograph =  photographDAO.findByActivationCode(code);
       if (photograph == null){
           return false;
       }
       photograph.setActivationCode(null);
       photographDAO.save(photograph);
    return true;
    }
}