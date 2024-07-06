package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;
import java.util.HashSet;
import java.util.Set;


@Data
public class RoleDto {

    private Integer id;    
    private String roleName;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

     private Set<UserRoleDto> userRoles = new HashSet<>();


}
