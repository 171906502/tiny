package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class ApiRequestLogDto {

    private Integer requestId;    
    private Integer userId;    
    private String apiEndpoint;    
    private String requestMethod;    
    private String requestParams;    
    private Integer responseStatus;    
    private String responseBody;    
    private LocalDateTime createdAt;    

}
