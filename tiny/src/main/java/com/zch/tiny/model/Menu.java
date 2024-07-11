package com.zch.tiny.model;

import jakarta.persistence.*;
import java.time.*;
import java.util.List;

import com.zch.tiny.enumeration.MenuTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "menu_type")
    @Enumerated(EnumType.STRING)
    private MenuTypeEnum menuType;

    @OneToOne
	@JoinColumn(name = "permission_id")
    private Permission permission;
    

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "menuId", insertable = false, updatable = false)
    private List<Menu> children;

}
