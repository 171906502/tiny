package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class NotificationDto {

    private Integer notification_id;
    private Integer user_id;
    private String title;
    private String message;
    private String is_read;
    private LocalDateTime created_at;

}
