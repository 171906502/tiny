package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue
    private Integer roleId;
    
    @Column(name = "permission_id")
    private Integer permissionId;
    


}
