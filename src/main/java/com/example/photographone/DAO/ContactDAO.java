package com.example.photographone.DAO;

import com.example.photographone.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContactDAO  extends JpaRepository<Contact,Integer> {
    List<Contact> findByCity_NameCity(String nameCity);

}
