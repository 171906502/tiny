package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class NotificationDto {

    @NotNull
    private Integer notification_id;
    @NotNull
    private Integer user_id;
    @NotNull
    private String title;
    @NotNull
    private String message;
    @NotNull
    private String is_read;
    @NotNull
    private LocalDateTime created_at;

}
