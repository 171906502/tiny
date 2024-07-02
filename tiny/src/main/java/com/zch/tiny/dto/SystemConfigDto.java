package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class SystemConfigDto {

    private Integer config_id;
    
    private String config_key;
    
    private String config_value;
    
    private String description;
    
    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;
    

}
