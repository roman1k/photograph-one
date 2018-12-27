package com.example.photographone.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String email;
    private long number;
    private String facebook;
    private String instagram;
    @ManyToOne
    private  City city;

    //constuctors
    public  Contact(){}
    public Contact(String email, long number, String facebook, String instagram, City city1) {
    }

    public Contact(String email) {
        this.email = email;
    }
    //getter and setter

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", number=" + number +
                ", facebook='" + facebook + '\'' +
                ", instagram='" + instagram + '\'' +
                '}';
    }
}
