package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class TaskScheduleDto {

    private Integer schedule_id;
    private Integer task_id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private String status;
    private String message;
    private LocalDateTime created_at;

}
