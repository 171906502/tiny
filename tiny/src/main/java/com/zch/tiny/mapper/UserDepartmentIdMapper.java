package com.zch.tiny.mapper;



import com.zch.tiny.dto.UserDepartmentIdDto;
import com.zch.tiny.model.UserDepartmentId;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDepartmentIdMapper {
    UserDepartmentIdMapper INSTANCE = Mappers.getMapper(UserDepartmentIdMapper.class);

    UserDepartmentId toEntity(UserDepartmentIdDto dto);

    UserDepartmentIdDto toDto(UserDepartmentId entity);
}
