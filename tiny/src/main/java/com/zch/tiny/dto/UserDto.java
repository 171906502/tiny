package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class UserDto {

    private Integer userId;    
    private String username;    
    private String password;    
    private String email;    
    private String phone;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

}
