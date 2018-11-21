package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCity;
//constructor
    public City() {
    }

    public City(String nameCity) {
        this.nameCity = nameCity;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                '}';
    }
}
