package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Photograph  extends UserDepended{
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserDepended userDepended;
    @OneToMany
    private List<Gallery> galleries = new ArrayList<>();
    @OneToOne
    private  Rating rating;
    private Sex sex;
    private String description;
    private  String avatar;

}
