package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class OperationLogDto {

    @NotNull
    private Integer log_id;
    @NotNull
    private Integer user_id;
    @NotNull
    private String operation;
    @NotNull
    private String ip_address;
    @NotNull
    private LocalDateTime created_at;

}
