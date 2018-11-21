package com.example.photographone.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCity;
    @OneToMany
    private List<Contact> contacts;
//constructor
    public City() {
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", contacts=" + contacts +
                '}';
    }
}
