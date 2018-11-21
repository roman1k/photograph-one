package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    private int countOfLke;
    private String hashtag;
    @OneToMany
    private List<UserDepended> whoLiked = new ArrayList<>();


    //constructor
    public Photo() {
    }

    public Photo(String name, int countOfLke, String hashtag, List<UserDepended> whoLiked) {
        this.name = name;
        this.countOfLke = countOfLke;
        this.hashtag = hashtag;
        this.whoLiked = whoLiked;
    }


    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCountOfLke(int countOfLke) {
        this.countOfLke = countOfLke;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void setWhoLiked(List<UserDepended> whoLiked) {
        this.whoLiked = whoLiked;
    }

    public String getName() {

        return name;
    }

    public int getCountOfLke() {
        return countOfLke;
    }

    public String getHashtag() {
        return hashtag;
    }

    public List<UserDepended> getWhoLiked() {
        return whoLiked;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countOfLke=" + countOfLke +
                ", hashtag='" + hashtag + '\'' +
                ", whoLiked=" + whoLiked +
                '}';
    }
}
