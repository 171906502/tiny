package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class TaskScheduleDto {

    private Integer scheduleId;    
    private Integer taskId;    
    private LocalDateTime startTime;    
    private LocalDateTime endTime;    
    private String status;    
    private String message;    
    private LocalDateTime createdAt;    

}
