package com.example.photographone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Gallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameGallery;
    @ManyToOne
    private Photograph photograph;
    @OneToMany
    private List<Photo> photos = new ArrayList<Photo>();

    public Gallery(){}

    public Gallery(String nameGallery, Photograph photograph, List<Photo> photos) {
        this.nameGallery = nameGallery;
        this.photograph = photograph;
        this.photos = photos;
    }



    public void setNameGallery(String nameGallery) {
        this.nameGallery = nameGallery;
    }

    public void setPhotograph(Photograph photograph) {
        this.photograph = photograph;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "id=" + id +
                ", nameGallery='" + nameGallery + '\'' +
                ", photograph=" + photograph +
                ", photos=" + photos +
                '}';
    }

    public String getNameGallery() {
        return nameGallery;
    }

    public Photograph getPhotograph() {
        return photograph;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

}
