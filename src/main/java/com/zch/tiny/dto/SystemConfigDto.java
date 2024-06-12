package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class SystemConfigDto {

    @NotNull
    private Integer config_id;
    @NotNull
    private String config_key;
    @NotNull
    private String config_value;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime updated_at;

}
