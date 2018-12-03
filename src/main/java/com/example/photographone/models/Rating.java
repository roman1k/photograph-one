package com.example.photographone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  double mark;
    private  int count;

    // constructor
    public Rating() {
    }
    //getter setter
    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", mark=" + mark +
                '}';
    }
}