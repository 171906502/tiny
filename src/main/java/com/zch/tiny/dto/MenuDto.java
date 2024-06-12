package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class MenuDto {

    @NotNull
    private Integer menu_id;
    @NotNull
    private Integer parent_id;
    @NotNull
    private String menu_name;
    @NotNull
    private String menu_path;
    @NotNull
    private String icon;
    @NotNull
    private Integer order_num;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime updated_at;
    @NotNull
    private String status;

}
