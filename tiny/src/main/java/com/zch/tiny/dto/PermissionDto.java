package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class PermissionDto {

    private Integer permissionId;    
    private String permissionName;    
    private String permissionCode;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

}
