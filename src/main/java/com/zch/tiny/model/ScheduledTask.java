package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "scheduled_task")
public class ScheduledTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    
    @Column(name = "task_name")
    private String taskName;
    
    @Column(name = "cron_expression")
    private String cronExpression;
    
    @Column(name = "task_script")
    private String taskScript;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "status")
    private String status;
    


}
