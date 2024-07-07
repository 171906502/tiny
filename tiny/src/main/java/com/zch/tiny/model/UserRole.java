package com.zch.tiny.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_role")
public class UserRole {
    @EmbeddedId
    private UserRoleId userRoleId = new UserRoleId();//必须有默认值，不然jpa保存会空异常

    @ManyToOne()
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonBackReference("user")
    private User user;

    @ManyToOne()
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    @JsonBackReference("role")
    private Role role;

    public UserRoleId getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRoleId userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



}
