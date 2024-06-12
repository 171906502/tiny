package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class UserDepartmentDto {

    @NotNull
    private Integer user_id;
    @NotNull
    private Integer department_id;

}
