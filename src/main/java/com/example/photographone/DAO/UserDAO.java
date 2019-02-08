package com.example.photographone.DAO;

import com.example.photographone.models.Contact;
import com.example.photographone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDAO extends JpaRepository<User, Integer> {
     User findByUsername(String username);
     User findByUserDep_Contact_Email(String email);
     User findByActivationCode(String code);


}
