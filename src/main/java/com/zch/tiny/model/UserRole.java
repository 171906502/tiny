package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue
    private Integer userId;
    
    @Column(name = "role_id")
    private Integer roleId;
    


}
