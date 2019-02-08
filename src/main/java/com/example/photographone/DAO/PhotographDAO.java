package com.example.photographone.DAO;

import com.example.photographone.models.Photograph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotographDAO extends JpaRepository<Photograph, Integer> {

  ;
}
