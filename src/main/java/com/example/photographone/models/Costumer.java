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
    private Role role = Role.ROLE_COSTUMER;

    public Costumer() {
    }

    public Costumer(UserDepended userDepended, int count, Role role) {
        this.userDepended = userDepended;
        this.count = count;
        this.role = role;
    }

    public UserDepended getUserDepended() {
        return userDepended;
    }

    public void setUserDepended(UserDepended userDepended) {
        this.userDepended = userDepended;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
