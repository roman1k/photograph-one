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

import java.util.List;
import java.util.stream.Collectors;

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
    public void saveAdmin(User user, Contact contact) {
        contactDAO.save(contact);
        Costumer costumer = new Costumer();
        costumer.setContact(contact);
        costumerDAO.save(costumer);
        user.setUserDep(costumer);
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        System.out.println("2________________________________");
        user.setRole(Role.ROLE_ADMIN);
        userDAO.save(user);
    }




    @Override
    public List<User> selectPhotographs(Search search) {
        List<User>  photographs  = userDAO.findAll().stream()
                                            .filter(user -> user.getUserDep()instanceof Photograph)
                                            .collect(Collectors.toList());
        System.out.println(search + "__________111111111111111111111111");
        if (search.getCity()!=null) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            String city = search.getCity();
            photographs = photographs.stream()
                                .filter(user -> (user.getUserDep().getContact().getCity().getNameCity()).equals(city))
                                .collect(Collectors.toList());
        }
        if (search.getPriceLower()!=0){
            System.out.println("+++++++++++++++++++++++++++++++++1111");
            int priceLower = search.getPriceLower();
            photographs = photographs.stream()
                            .filter(user -> (user.getUserDep()instanceof Photograph))
                            .filter(user -> ((Photograph) user.getUserDep()).getPrice()>priceLower)
                            .collect(Collectors.toList());
        }
       if (search.getPriceHigher()!=0) {
           System.out.println("+++++++++++++++++++++++++++++++++2222");

           int priceHigher = search.getPriceHigher();
           photographs = photographs.stream()
                   .filter(user -> (user.getUserDep() instanceof Photograph))
                   .filter(user -> ((Photograph) user.getUserDep()).getPrice() < priceHigher)
                   .collect(Collectors.toList());
       }
       return photographs;

    }

    @Override
    public List<User> allUser() {

        return userDAO.findAll();
    }
}