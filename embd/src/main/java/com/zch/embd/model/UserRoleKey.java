package com.zch.embd.model;
import java.io.Serializable;
import java.util.*;
import jakarta.persistence.*;

@Embeddable
public class UserRoleKey implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    // hashCode and equals methods

    
}