package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ScheduledTaskDto {

    @NotNull
    private Integer task_id;
    @NotNull
    private String task_name;
    @NotNull
    private String cron_expression;
    @NotNull
    private String task_script;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime updated_at;
    @NotNull
    private String status;

}
