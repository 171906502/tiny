package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class SessionDto {

    @NotNull
    private String session_id;
    @NotNull
    private Integer user_id;
    @NotNull
    private String ip_address;
    @NotNull
    private String user_agent;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime expires_at;

}
