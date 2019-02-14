package com.example.photographone.service;

import com.example.photographone.models.Contact;
import com.example.photographone.models.Photograph;
import com.example.photographone.models.Sex;

public interface PhotographService {
      void save(Photograph photograph, Contact contact);
      Photograph getPhotograph(String avatar, String firstName, String lastName,
                               int Age, Sex sex, String description,
                               String email,long number,String facebook,
                               String instagram,String city,int Prise,
                               String nameGallery,String photos, Photograph photograph);


}
