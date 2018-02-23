package com.example.demo.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String position;

    private String organization;

    private  String descrption;

    private String catagory;

    @ManyToMany
    private Set<Skill> skillSet;

    public Job() {
        this.skillSet= new HashSet<Skill>();
    }

    public Job(String position, String organization, String descrption, String catagory) {
        this.position = position;
        this.organization = organization;
        this.descrption = descrption;
        this.catagory = catagory;
        this.skillSet= new HashSet<Skill>();
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

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public void AddSkill(Skill s){this.skillSet.add(s);}
}
