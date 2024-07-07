package com.zch.tiny.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto {


    private UserRoleIdDto UserRoleId;

    @JsonBackReference("RoleDto")
    private RoleDto role;

    @JsonBackReference("UserDto")
    private UserDto user;
}
