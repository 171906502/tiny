package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class RoleDto {

    private Integer role_id;
    private String role_name;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String status;

}
