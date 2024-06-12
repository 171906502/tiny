package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class FileDto {

    @NotNull
    private Integer file_id;
    @NotNull
    private String file_name;
    @NotNull
    private String file_path;
    @NotNull
    private Integer file_size;
    @NotNull
    private String file_type;
    @NotNull
    private Integer uploaded_by;
    @NotNull
    private LocalDateTime uploaded_at;
    @NotNull
    private String status;

}
