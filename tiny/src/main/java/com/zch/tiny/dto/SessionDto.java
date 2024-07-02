package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class SessionDto {

    private String sessionId;    
    private Integer userId;    
    private String ipAddress;    
    private String userAgent;    
    private LocalDateTime createdAt;    
    private LocalDateTime expiresAt;    

}
