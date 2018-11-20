package com.example.photographone.DAO;

import com.example.photographone.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactDAO  extends JpaRepository<Contact,Integer> {

}
