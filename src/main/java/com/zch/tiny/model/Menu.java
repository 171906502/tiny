package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue
    private Integer menuId;
    
    @Column(name = "parent_id")
    private Integer parentId;
    
    @Column(name = "menu_name")
    private String menuName;
    
    @Column(name = "menu_path")
    private String menuPath;
    
    @Column(name = "icon")
    private String icon;
    
    @Column(name = "order_num")
    private Integer orderNum;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "status")
    private String status;
    


}
