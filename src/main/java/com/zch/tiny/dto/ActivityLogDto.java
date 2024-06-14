package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class ActivityLogDto {

    private Integer activity_id;
    private Integer user_id;
    private String activity_type;
    private String activity_details;
    private LocalDateTime created_at;

}
