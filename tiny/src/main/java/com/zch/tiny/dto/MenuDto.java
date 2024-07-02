package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class MenuDto {

    private Integer menu_id;
    
    private Integer parent_id;
    
    private String menu_name;
    
    private String menu_path;
    
    private String icon;
    
    private Integer order_num;
    
    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;
    
    private String status;
    

}
