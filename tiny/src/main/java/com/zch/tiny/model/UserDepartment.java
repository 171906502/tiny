package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_department")
public class UserDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    
    @Column(name = "department_id")
    private Integer departmentId;
    


}
