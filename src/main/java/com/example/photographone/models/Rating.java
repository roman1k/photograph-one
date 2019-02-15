package com.example.photographone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  double mark;
    private  int count;
    private  int averageMark;

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

    public int getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating = (Rating) o;
        return getId() == rating.getId() &&
                Double.compare(rating.getMark(), getMark()) == 0 &&
                getCount() == rating.getCount() &&
                getAverageMark() == rating.getAverageMark();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMark(), getCount(), getAverageMark());
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", mark=" + mark +
                '}';
    }
}