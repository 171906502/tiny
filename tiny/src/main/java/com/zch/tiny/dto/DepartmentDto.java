package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class DepartmentDto {

    private Integer department_id;
    
    private Integer parent_id;
    
    private String department_name;
    
    private String description;
    
    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;
    
    private String status;
    

}
