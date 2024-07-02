package com.zch.tiny.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class UserRoleId implements Serializable {
    private Integer userId;
    private Integer roleId;

    public UserRoleId(Integer userId, Integer roleId) {
        this.roleId=roleId;
        this.userId=userId;
    }
}