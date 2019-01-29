package com.example.photographone.service.implem;

import com.example.photographone.DAO.ContactDAO;
import com.example.photographone.DAO.PhotographDAO;
import com.example.photographone.models.*;
import com.example.photographone.service.PhotographService;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class PhotographServiceImpl implements PhotographService {
    @Autowired
    private PhotographDAO photographDAO;
    private ContactDAO contactDAO;

    @Override
    public void save(Photograph photograph) {
        photographDAO.save(photograph);
    }

//    @Override
//    public Photograph getPhotograph(String avatar, String firstName, String lastName,
//                             int Age, Sex sex, String description,
//                             String email, long number, String facebook,
//                             String instagram, String city,int Sale,
//                             String nameGallery, String photos,  Photograph photograph){
//        photograph.getUserDepended().setFirstName(firstName);
//        photograph.getUserDepended().setLastName(lastName);
//        City city1 = new City();
//        city1.setNameCity(city);
//        Contact contact = new Contact(email,number, facebook, instagram, city1);
//        contactDAO.save(contact);
//        photograph.getUserDepended().setContact(contact);
//        photograph.setAge(Age);
//        photograph.setDescription(description);
//        photograph.setSale(Sale);
//        photograph.setAvatar(avatar);
//        List<Photo> photos1 = new ArrayList<Photo>();
//        String[] arrOfStr = photos.split(" ");
//        List<Gallery> galleries = new ArrayList<>();
//        Gallery gallery = new Gallery(nameGallery, photograph, photos1);
//        galleries.add(gallery);
//        photograph.setGalleries(galleries);
//        photograph.setAge(Age);
//        return photograph;
//    }
}
