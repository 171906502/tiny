package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class PermissionDto {

    @NotNull
    private Integer permission_id;
    @NotNull
    private String permission_name;
    @NotNull
    private String permission_code;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime updated_at;
    @NotNull
    private String status;

}
