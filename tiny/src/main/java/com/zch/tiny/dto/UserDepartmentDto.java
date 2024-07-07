package com.zch.tiny.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class UserDepartmentDto {

    private UserDepartmentIdDto id;

    @JsonBackReference("UserDto")
    private UserDto user;

    @JsonBackReference("DepartmentDto")
    private DepartmentDto department;

}
