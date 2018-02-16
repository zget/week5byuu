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

   //@NotEmpty
    private String company;

    //@NotEmpty
    private int serviceyear;

   // @NotEmpty
    private String duty;

    public Experience() {
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

    public String getCompany() {
        return company;
    }

    public void setComapany(String comapany) {
        this.company = comapany;
    }

    public int getServiceyear() {
        return serviceyear;
    }

    public void setServiceyear(int serviceyear) {
        this.serviceyear = serviceyear;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
