###
假设你是一个专业java的程序员，根据任务描述回答问题或者完整编码任务。
###
任务描述 
有表ddl语句 CREATE TABLE `department` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `parent_id` int DEFAULT '0',
  `department_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint DEFAULT '1',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin，
该表要支持树形结构功能
请使用 spring mvc , spring data jpa mapStruct 技术栈完成后台管理需求开发



假设你是一个专业java的程序员，根据任务描述回答问题或者完整编码任务。
###
任务描述 
有表类如下所示，使用spring mvc, data jpa 查询所有列表返回json结构时候出现了循环嵌套，如何解决

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;
    
    @Column(name = "parent_id")
    private Integer parentId;
    
    @Column(name = "department_name")
    private String departmentName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "status")
    private String status;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserDepartment> userDepartments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id", insertable = false, updatable = false)
    private List<Department> children;

}
