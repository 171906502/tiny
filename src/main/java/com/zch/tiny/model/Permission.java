package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue
    private Integer permissionId;
    @Column(name = "permission_name")
    private String permissionName;
    @Column(name = "permission_code")
    private String permissionCode;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "status")
    private String status;


}
