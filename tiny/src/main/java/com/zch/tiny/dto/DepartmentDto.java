package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Data
public class DepartmentDto {

    private Integer departmentId;
    @NotNull  
    private Integer parentId;  
    @NotBlank  
    private String departmentName;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    
    private String status;    
    private List<DepartmentDto> children;
    // private Set<UserDepartment> userDepartments = new HashSet<>();

}
