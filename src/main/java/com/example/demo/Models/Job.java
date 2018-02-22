package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String position;

    private String organization;

    private  String descrption;

    ArrayList<String> desiredSkill;

    public Job() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public ArrayList<String> getDesiredSkill() {
        return desiredSkill;
    }

    public void setDesiredSkill(ArrayList<String> desiredSkill) {
        this.desiredSkill = desiredSkill;
    }
}
