


假设你是一个专业java的程序员，根据任务描述回答问题或者完整编码任务。
###
任务描述 
有数据库实体表类如下所示，使用spring mvc, data jpa ，mapstruct技术栈实现后台管理功能，生成详细实现代码。
要求menu支持树形结构功能，同时要检查menu所关联的permission是否存在记录。只需生成menu的代码

package com.zch.tiny.model;
import jakarta.persistence.*;
import java.time.*;
import java.util.List;

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


import jakarta.persistence.*;
import java.time.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;
    
    @Column(name = "permission_code")
    private String permissionCode;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "status")
    private String status;
    


}

