package com.zch.tiny.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class UserDto {

    @NotNull
    private Integer user_id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime updated_at;
    @NotNull
    private String status;

}
