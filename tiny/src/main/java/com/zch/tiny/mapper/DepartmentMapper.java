package com.zch.tiny.mapper;

import com.zch.tiny.model.Department;
import com.zch.tiny.dto.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    Department toEntity(DepartmentDto dto);

    DepartmentDto toDto(Department entity);
}
