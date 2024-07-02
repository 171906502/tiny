package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserDepartment> userDepartments = new HashSet<>();

}
