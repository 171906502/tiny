package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class PermissionDto {

    private Integer permission_id;
    
    private String permission_name;
    
    private String permission_code;
    
    private String description;
    
    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;
    
    private String status;
    

}
