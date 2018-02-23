package com.example.demo.Models;


import com.example.demo.Security.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

   // @NotEmpty
    private String achievement;

   // @NotEmpty
    private String school;

    //@NotEmpty
    private int gradyear;

    @ManyToMany(mappedBy= "educations")
    private Collection<User> userEducation;

    public Education() {

        this.userEducation=new HashSet<User>();
    }

    public Education(String achievement, String school, int gradyear) {
        this.achievement = achievement;
        this.school = school;
        this.gradyear = gradyear;
        this.userEducation=new HashSet<User>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGradyear() {
        return gradyear;
    }

    public void setGradyear(int gradyear) {
        this.gradyear = gradyear;
    }

}
