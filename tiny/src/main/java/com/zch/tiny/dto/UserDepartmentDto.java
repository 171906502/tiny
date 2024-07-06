package com.zch.tiny.dto;

import lombok.Data;

@Data
public class UserDepartmentDto {

    private UserDepartmentIdDto userDepartmentId;
    private UserDto user;
    private DepartmentDto department;

}
