package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class SystemConfigDto {

    private Integer configId;    
    private String configKey;    
    private String configValue;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    

}
