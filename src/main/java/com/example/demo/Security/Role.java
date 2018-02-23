package com.example.demo.Security;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String role;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Collection<User> users;

    public Role() {

        this.users=new HashSet<User>();
    }

    public Role(String role) {
        this.role = role;
        this.users=new HashSet<User>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public String getRole() {
        return role;
    }

    public Collection<User> getUsers() {
        return users;
    }

}
