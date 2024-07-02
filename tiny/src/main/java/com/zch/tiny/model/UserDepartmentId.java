package com.zch.tiny.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class UserDepartmentId implements Serializable {
    private Integer userId;
    private Integer departmentId;

    public UserDepartmentId(Integer userId, Integer departmentId) {
        this.userId=userId;
        this.departmentId=departmentId;
    }
}
