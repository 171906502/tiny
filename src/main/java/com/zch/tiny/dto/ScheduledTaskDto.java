package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class ScheduledTaskDto {

    private Integer task_id;
    
    private String task_name;
    
    private String cron_expression;
    
    private String task_script;
    
    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;
    
    private String status;
    

}
