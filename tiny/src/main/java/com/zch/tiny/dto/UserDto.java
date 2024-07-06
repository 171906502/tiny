package com.zch.tiny.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

import java.time.*;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {

    private Integer id;
    private String username;    
    private String password;
    @NotBlank
    private String email;    
    private String phone;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;
    private Byte status;

    private Set<UserRoleDto> userRoles = new HashSet<>();

}
