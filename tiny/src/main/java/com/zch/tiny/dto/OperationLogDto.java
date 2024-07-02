package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class OperationLogDto {

    private Integer logId;    
    private Integer userId;    
    private String operation;    
    private String ipAddress;    
    private LocalDateTime createdAt;    

}
