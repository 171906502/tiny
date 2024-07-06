package com.zch.tiny.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_department")
public class UserDepartment {
    @EmbeddedId
    private UserDepartmentId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @MapsId("departmentId")
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;
}

