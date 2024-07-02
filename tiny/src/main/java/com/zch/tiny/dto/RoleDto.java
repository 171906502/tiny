package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class RoleDto {

    private Integer roleId;    
    private String roleName;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

}
