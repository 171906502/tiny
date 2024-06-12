package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue
    private Integer departmentId;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "status")
    private String status;


}
