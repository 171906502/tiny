package com.zch.tiny.mapper;

import com.zch.tiny.model.User;
import com.zch.tiny.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}
