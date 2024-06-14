package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class OperationLogDto {

    private Integer log_id;
    private Integer user_id;
    private String operation;
    private String ip_address;
    private LocalDateTime created_at;

}
