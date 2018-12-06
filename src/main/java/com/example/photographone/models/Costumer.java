package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Costumer")
public class Costumer extends UserDepended {
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserDepended userDepended;
    @OneToMany
    private List<UserDepended> selected = new ArrayList<>();

    //constructor
    public Costumer() {
    }
    //getter and setter
    public UserDepended getUserDepended() {
        return userDepended;
    }

    public void setUserDepended(UserDepended userDepended) {
        this.userDepended = userDepended;
    }

    public List<UserDepended> getSelected() {
        return selected;
    }

    public void setSelected(List<UserDepended> selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name" + getFirstName()+
                '}';
    }
}