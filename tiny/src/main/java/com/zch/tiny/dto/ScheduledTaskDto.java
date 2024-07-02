package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class ScheduledTaskDto {

    private Integer taskId;    
    private String taskName;    
    private String cronExpression;    
    private String taskScript;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

}
