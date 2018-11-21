package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Gallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameGallery;
    @ManyToOne
    private Photograph photograph;
    @OneToMany
    private List<Photo> photos = new ArrayList<Photo>();



}
