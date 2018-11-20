package com.example.photographone.models;

import javax.persistence.*;

@Entity
@Table(name = "Costumer")
public class Costumer extends UserDepended {
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserDepended userDepended;
    private  int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" +
                ", count=" + count +
                '}';
    }
}
