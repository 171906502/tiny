package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class ApiRequestLogDto {

    private Integer request_id;
    private Integer user_id;
    private String api_endpoint;
    private String request_method;
    private String request_params;
    private Integer response_status;
    private String response_body;
    private LocalDateTime created_at;

}
