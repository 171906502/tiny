package com.zch.embd.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<UserRole> roles = new HashSet<>();

    // Getters and Setters

    // Helper methods to manage bi-directional relationship
    public void addRole(Role role) {
        UserRole userRole = new UserRole();
        userRole.setUser(this);
        userRole.setRole(role);
        roles.add(userRole);
        // role.getUserRoles().add(userRole);
    }

    public void removeRole(Role role) {
        for (Iterator<UserRole> iterator = roles.iterator(); iterator.hasNext(); ) {
            UserRole userRole = iterator.next();
            if (userRole.getUser().equals(this) && userRole.getRole().equals(role)) {
                iterator.remove();
                userRole.getRole().getUserRoles().remove(userRole);
                userRole.setUser(null);
                userRole.setRole(null);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    

    // Getters and Setters
}
