package com.example.photographone.DAO;

import com.example.photographone.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingDAO extends JpaRepository<Rating, Integer> {
}
