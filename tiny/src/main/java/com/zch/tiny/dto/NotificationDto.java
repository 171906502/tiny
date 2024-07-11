package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class NotificationDto {

    private Integer notificationId;    
    private Integer userId;    
    private String title;    
    private String message;    
    private Boolean isRead;    
    private LocalDateTime createdAt;    
    private byte status;

}
