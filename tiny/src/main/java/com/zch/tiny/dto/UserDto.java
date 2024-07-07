package com.zch.tiny.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Data
public class UserDto {

    private Integer userId;
    private String username;  
    @JsonIgnore  
    private String password;
    @NotBlank
    private String email;    
    private String phone;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;
    private Byte status;

    @JsonManagedReference("UserDto")
    private Set<UserRoleDto> userRoles = new HashSet<>();

    @JsonManagedReference("UserDto")
    private Set<UserDepartmentDto> userDepartments = new HashSet<>();

}
