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
    private UserDepartmentId id = new UserDepartmentId();//必须有默认值，不然jpa保存会空异常

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonBackReference("user")
    private User user;

    @ManyToOne
    @MapsId("departmentId")
    @JoinColumn(name = "department_id")
    @JsonBackReference("department")
    private Department department;
}

