package com.zch.tiny.mapper;

import com.zch.tiny.model.AccessLog;
import com.zch.tiny.dto.AccessLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccessLogMapper {
    AccessLogMapper INSTANCE = Mappers.getMapper(AccessLogMapper.class);

    AccessLog toEntity(AccessLogDto dto);

    AccessLogDto toDto(AccessLog entity);
}
