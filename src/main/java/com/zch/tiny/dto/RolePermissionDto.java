package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class RolePermissionDto {

    @NotNull
    private Integer role_id;
    @NotNull
    private Integer permission_id;

}
