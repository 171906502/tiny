package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class DepartmentDto {

    private Integer departmentId;    
    private Integer parentId;    
    private String departmentName;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

}
