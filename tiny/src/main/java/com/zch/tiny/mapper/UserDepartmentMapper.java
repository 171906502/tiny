package com.zch.tiny.mapper;


import com.zch.tiny.dto.UserDepartmentDto;
import com.zch.tiny.model.UserDepartment;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDepartmentMapper {
    UserDepartmentMapper INSTANCE = Mappers.getMapper(UserDepartmentMapper.class);

    UserDepartment toEntity(UserDepartmentDto dto);

    UserDepartmentDto toDto(UserDepartment entity);
}
