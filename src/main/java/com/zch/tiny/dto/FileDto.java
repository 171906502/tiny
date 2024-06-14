package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class FileDto {

    private Integer file_id;
    private String file_name;
    private String file_path;
    private Integer file_size;
    private String file_type;
    private Integer uploaded_by;
    private LocalDateTime uploaded_at;
    private String status;

}
