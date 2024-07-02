package com.zch.tiny.mapper;

import com.zch.tiny.model.ApiRequestLog;
import com.zch.tiny.dto.ApiRequestLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApiRequestLogMapper {
    ApiRequestLogMapper INSTANCE = Mappers.getMapper(ApiRequestLogMapper.class);

    ApiRequestLog toEntity(ApiRequestLogDto dto);

    ApiRequestLogDto toDto(ApiRequestLog entity);
}
