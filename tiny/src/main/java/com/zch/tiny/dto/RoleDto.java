package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Data
public class RoleDto {

    private Integer roleId;    
    private String roleName;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

    @JsonManagedReference("RoleDto")
    private Set<UserRoleDto> userRoles = new HashSet<>();


}
