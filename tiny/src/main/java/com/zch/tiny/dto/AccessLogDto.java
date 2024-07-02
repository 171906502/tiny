package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class AccessLogDto {

    private Integer accessId;    
    private Integer userId;    
    private String ipAddress;    
    private String requestUrl;    
    private String requestMethod;    
    private Integer responseStatus;    
    private LocalDateTime createdAt;    

}
