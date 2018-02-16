package com.example.demo.Models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    //@NotEmpty
    private String skillname;

   // @NotEmpty
    private int skillrating;


    public Skill() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public int getSkillrating() {
        return skillrating;
    }

    public void setSkillrating(int skillrating) {
        this.skillrating = skillrating;
    }
}
