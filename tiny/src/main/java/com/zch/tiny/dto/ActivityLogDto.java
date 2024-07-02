package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class ActivityLogDto {

    private Integer activityId;    
    private Integer userId;    
    private String activityType;    
    private String activityDetails;    
    private LocalDateTime createdAt;    

}
