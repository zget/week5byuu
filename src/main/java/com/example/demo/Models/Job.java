package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String position;

    private String organization;

    private  String descrption;

    ArrayList<String> desiredSkill;

}
