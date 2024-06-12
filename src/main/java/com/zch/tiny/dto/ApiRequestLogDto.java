package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ApiRequestLogDto {

    @NotNull
    private Integer request_id;
    @NotNull
    private Integer user_id;
    @NotNull
    private String api_endpoint;
    @NotNull
    private String request_method;
    @NotNull
    private String request_params;
    @NotNull
    private Integer response_status;
    @NotNull
    private String response_body;
    @NotNull
    private LocalDateTime created_at;

}
