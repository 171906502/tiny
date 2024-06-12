package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

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
