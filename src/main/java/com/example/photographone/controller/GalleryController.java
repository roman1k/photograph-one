package com.example.photographone.controller;

import com.example.photographone.DAO.GalleryDAO;
import com.example.photographone.models.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GalleryController {
    @Autowired
    GalleryDAO galleryDAO;
    @GetMapping("/gallery")
    public String gallery(){
        return "gallery";
    }
    @PostMapping("/savenewFolder")
    public String savenewFolder(){
        galleryDAO.save(new Gallery());
        return "";
    }
}
