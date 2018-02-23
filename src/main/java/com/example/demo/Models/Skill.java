package com.example.demo.Models;


import com.example.demo.Security.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String skillname;

    private int skillrating;

    @ManyToMany(mappedBy = "skillSet")
        private Set<Job> jobs;


    @ManyToMany(mappedBy = "skilluser")
    private Collection<User> uskill;


    public Skill() {
        this.jobs=new HashSet<Job>();
        this.uskill= new HashSet<User>();

    }

    public Skill(String skillname, int skillrating) {
        this.skillname = skillname;
        this.skillrating = skillrating;
        this.jobs=new HashSet<Job>();
        this.uskill= new HashSet<User>();

    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public Collection<User> getUskill() {
        return uskill;
    }

    public void setUskill(Collection<User> uskill) {
        this.uskill = uskill;
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
