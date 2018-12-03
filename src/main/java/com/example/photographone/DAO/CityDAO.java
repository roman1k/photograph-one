package com.example.photographone.DAO;

import com.example.photographone.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO  extends JpaRepository<City, Integer> {

}
