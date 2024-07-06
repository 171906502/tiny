package com.zch.embd.model;

import java.util.*;
import jakarta.persistence.*;



@Entity
public class RolePermission {
    @EmbeddedId
    private RolePermissionKey id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    private Permission permission;

    public RolePermissionKey getId() {
        return id;
    }

    public void setId(RolePermissionKey id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    // Getters and Setters

    

}