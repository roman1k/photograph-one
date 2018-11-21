package com.example.photographone.DAO;

import com.example.photographone.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDAO extends JpaRepository<City, Integer> {
    List<City> findAll();
}
