package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class UserDto {

    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String status;

}
