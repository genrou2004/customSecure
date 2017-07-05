package com.security.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by student on 7/5/17.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    private String role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Collection<User> users;

    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
