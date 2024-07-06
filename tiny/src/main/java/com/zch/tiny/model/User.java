package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Byte status = 1;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<UserDepartment> userDepartments = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<UserRole> userRoles = new HashSet<>();

    

    // Helper methods to manage bi-directional relationship
    public void addRole(Role role) {
        UserRole userRole = new UserRole();
        userRole.setUser(this);
        userRole.setRole(role);
        userRoles.add(userRole);
        // role.getUserRoles().add(userRole);
    }

    public void removeRole(Role role) {
        for (Iterator<UserRole> iterator = userRoles.iterator(); iterator.hasNext();) {
            UserRole userRole = iterator.next();
            if (userRole.getUser().equals(this) && userRole.getRole().equals(role)) {
                iterator.remove();
                userRole.getRole().getUserRoles().remove(userRole);
                userRole.setUser(null);
                userRole.setRole(null);
            }
        }
    }


    

}
