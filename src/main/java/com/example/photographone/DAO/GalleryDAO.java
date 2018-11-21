package com.example.photographone.DAO;

import com.example.photographone.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryDAO extends JpaRepository<Gallery, Integer> {

}
