package com.example.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    //@NotEmpty
    private String position;

   // @NotEmpty
    private String comapany;

    //@NotEmpty
    private int serviceyear;

    //@NotEmpty
    private String duty;

}
