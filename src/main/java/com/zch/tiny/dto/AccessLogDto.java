package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class AccessLogDto {

    @NotNull
    private Integer access_id;
    @NotNull
    private Integer user_id;
    @NotNull
    private String ip_address;
    @NotNull
    private String request_url;
    @NotNull
    private String request_method;
    @NotNull
    private Integer response_status;
    @NotNull
    private LocalDateTime created_at;

}
