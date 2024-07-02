package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class MenuDto {

    private Integer menuId;    
    private Integer parentId;    
    private String menuName;    
    private String menuPath;    
    private String icon;    
    private Integer orderNum;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    

}
