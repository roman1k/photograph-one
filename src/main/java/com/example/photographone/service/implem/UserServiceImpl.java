package com.example.photographone.service.implem;


import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.PhotographDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.Contact;
import com.example.photographone.models.Costumer;
import com.example.photographone.models.Role;
import com.example.photographone.models.User;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    private  PhotographDAO photographDAO;

    @Autowired
    private CostumerDAO costumerDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    @Override
    public void save(User user) {
        Contact contact = new Contact("123");
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
}