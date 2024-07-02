package com.zch.tiny.mapper;

import com.zch.tiny.model.Session;
import com.zch.tiny.dto.SessionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    Session toEntity(SessionDto dto);

    SessionDto toDto(Session entity);
}
