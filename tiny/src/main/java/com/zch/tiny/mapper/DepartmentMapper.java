package com.zch.tiny.mapper;

import com.zch.tiny.model.Department;
import com.zch.tiny.dto.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    Department toEntity(DepartmentDto dto);

    @Mappings({
        // 忽略 children 字段的映射
        @Mapping(target = "userDepartments", ignore = true)
    })
    DepartmentDto toDto(Department entity);
}
