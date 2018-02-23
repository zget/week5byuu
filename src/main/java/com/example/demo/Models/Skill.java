package com.example.demo.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String skillname;

    private int skillrating;

    @ManyToMany(mappedBy = "skillSet", fetch = FetchType.LAZY)
        private Set<Job> jobs;

    public Skill() {
        this.jobs=new HashSet<Job>();
    }

    public Skill(String skillname, int skillrating) {
        this.skillname = skillname;
        this.skillrating = skillrating;
        this.jobs=new HashSet<Job>();
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
