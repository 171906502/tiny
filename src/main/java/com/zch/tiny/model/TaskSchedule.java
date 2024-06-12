package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "task_schedule")
public class TaskSchedule {

    @Id
    @GeneratedValue
    private Integer scheduleId;
    @Column(name = "task_id")
    private Integer taskId;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "status")
    private String status;
    @Column(name = "message")
    private String message;
    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
