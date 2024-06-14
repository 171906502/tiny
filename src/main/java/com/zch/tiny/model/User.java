package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer userId;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "status")
    private String status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Collections.singleton(new SimpleGrantedAuthority("ROLE_user"));
    }
    


}
