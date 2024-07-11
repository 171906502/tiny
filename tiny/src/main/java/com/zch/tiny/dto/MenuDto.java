package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;
import java.util.List;

import com.zch.tiny.model.Menu;

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
    private String menuType;    
    private List<Menu> children;
}
