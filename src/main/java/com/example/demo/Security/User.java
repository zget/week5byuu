package com.example.demo.Security;

import com.example.demo.Models.Education;
import com.example.demo.Models.Skill;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "username")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @ManyToMany
    private Collection<Skill> skilluser;
    @ManyToMany
    private Collection<Education> educations;


    public User(String email, String password, String firstName, String lastName, boolean enabled, String userName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.userName = userName;
        this.roles= new HashSet<Role>();
        this.skilluser =new HashSet<Skill>();
        this.educations=new HashSet<Education>();
    }



    public User() {
        this.roles= new HashSet<Role>();
        this.skilluser =new HashSet<Skill>();
        this.educations=new HashSet<Education>();
    }



    public Collection<Skill> getSkilluser() {
        return skilluser;
    }

    public void setSkilluser(Collection<Skill> skilluser) {
        this.skilluser = skilluser;
    }


    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getUserName() {
        return userName;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role r){
        this.roles.add(r);
    }
    public void addUserSkill(Skill s){
        this.skilluser.add(s);
    }

    public void addUserEducation(Education e){
        this.educations.add(e);
    }
}
