package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "user_department")
public class UserDepartment {

    @Id
    @GeneratedValue
    private Integer userId;
    @Column(name = "department_id")
    private Integer departmentId;


}
