package com.zch.embd.model;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "permission")
    private Set<RolePermission> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RolePermission> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolePermission> roles) {
        this.roles = roles;
    }

    // Getters and Setters

    
}
