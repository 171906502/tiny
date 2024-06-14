package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class SessionDto {

    private String session_id;
    private Integer user_id;
    private String ip_address;
    private String user_agent;
    private LocalDateTime created_at;
    private LocalDateTime expires_at;

}
