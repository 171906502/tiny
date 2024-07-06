package com.zch.tiny.dto;

import lombok.Data;

@Data
public class UserRoleDto {

    private Integer userId;    
    private Integer roleId;    

    private RoleDto role;
    private UserDto user;
}
