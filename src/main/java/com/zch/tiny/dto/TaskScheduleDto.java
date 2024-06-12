package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TaskScheduleDto {

    @NotNull
    private Integer schedule_id;
    @NotNull
    private Integer task_id;
    @NotNull
    private LocalDateTime start_time;
    @NotNull
    private LocalDateTime end_time;
    @NotNull
    private String status;
    @NotNull
    private String message;
    @NotNull
    private LocalDateTime created_at;

}
