package com.example.photographone.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Costumer")
public class Costumer extends UserDepended {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    @OneToMany
    private List<User> selected = new ArrayList<>();

    //constructor
    public Costumer() {
    }
    //getter and setter

    public List<User> getSelected() {
        return selected;
    }

    public void setSelected(List<User> selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name" + id +
                '}';
    }
}