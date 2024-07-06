package com.zch.tiny.mapper;

import com.zch.tiny.model.User;
import com.zch.tiny.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // @Mapping(target = "userDepartments", ignore = true)
    // @Mapping(target = "userRoles", ignore = true)
    // @Mapping(target = "authorities", ignore = true)
    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}
