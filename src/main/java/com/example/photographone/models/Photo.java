package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int countOfLke;
    @OneToMany
    private List<UserDepended> whoLiked = new ArrayList<>();

    public Photo() {
    }
}
