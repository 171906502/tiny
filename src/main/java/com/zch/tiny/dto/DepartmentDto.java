package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class DepartmentDto {

    @NotNull
    private Integer department_id;
    @NotNull
    private Integer parent_id;
    @NotNull
    private String department_name;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime updated_at;
    @NotNull
    private String status;

}
