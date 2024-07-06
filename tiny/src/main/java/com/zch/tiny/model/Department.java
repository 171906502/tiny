package com.zch.tiny.model;

import jakarta.persistence.*;
import java.time.*;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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


    // @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonIgnore
    // private Set<UserDepartment> userDepartments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "departmentId", insertable = false, updatable = false)
    private List<Department> children;

}
