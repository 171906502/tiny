package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class DataDictionaryDto {

    @NotNull
    private Integer dictionary_id;
    @NotNull
    private String dict_type;
    @NotNull
    private String dict_key;
    @NotNull
    private String dict_value;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime updated_at;

}
