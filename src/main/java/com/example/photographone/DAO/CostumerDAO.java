package com.example.photographone.DAO;

import com.example.photographone.models.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface CostumerDAO  extends JpaRepository<Costumer, Integer> {



}
