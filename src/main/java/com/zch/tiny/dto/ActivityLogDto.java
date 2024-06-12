package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ActivityLogDto {

    @NotNull
    private Integer activity_id;
    @NotNull
    private Integer user_id;
    @NotNull
    private String activity_type;
    @NotNull
    private String activity_details;
    @NotNull
    private LocalDateTime created_at;

}
