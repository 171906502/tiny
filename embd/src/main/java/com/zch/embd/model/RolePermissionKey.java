package com.zch.embd.model;
import java.io.Serializable;
import java.util.*;
import jakarta.persistence.*;

@Embeddable
public class RolePermissionKey implements Serializable {
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "permission_id")
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    // hashCode and equals methods
    
}