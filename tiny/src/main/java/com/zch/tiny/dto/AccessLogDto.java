package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class AccessLogDto {

    private Integer access_id;
    
    private Integer user_id;
    
    private String ip_address;
    
    private String request_url;
    
    private String request_method;
    
    private Integer response_status;
    
    private LocalDateTime created_at;
    

}
