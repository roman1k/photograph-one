package com.example.photographone.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Photograph  extends UserDepended{
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserDepended userDepended;

}
