package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Photograph  extends UserDepended{
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserDepended userDepended;
    private Role role = Role.ROLE_PHOTOGRAPH;
    private  Rating rating;
    private Sex sex;
    private String description;
    private String avatar;

    public Photograph() {
    }

    public Photograph(UserDepended userDepended, Role role, List<Gallery> galleries, Rating rating, Sex sex, String description, String avatar) {
        this.userDepended = userDepended;
        this.role = role;

        this.rating = rating;
        this.sex = sex;
        this.description = description;
        this.avatar = avatar;
    }

    public UserDepended getUserDepended() {
        return userDepended;
    }

    public void setUserDepended(UserDepended userDepended) {
        this.userDepended = userDepended;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

