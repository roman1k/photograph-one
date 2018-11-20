package com.example.photographone.service.implem;


import com.example.photographone.DAO.UserDAO;
        import com.example.photographone.models.User;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);

    }
}