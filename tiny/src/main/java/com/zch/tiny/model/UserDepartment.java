package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_department")
@Data
public class UserDepartment {
    @EmbeddedId
    private UserDepartmentId id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("departmentId")
    private Department department;
}

