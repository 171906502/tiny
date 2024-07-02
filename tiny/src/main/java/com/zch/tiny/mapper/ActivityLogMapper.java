package com.zch.tiny.mapper;

import com.zch.tiny.model.ActivityLog;
import com.zch.tiny.dto.ActivityLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityLogMapper {
    ActivityLogMapper INSTANCE = Mappers.getMapper(ActivityLogMapper.class);

    ActivityLog toEntity(ActivityLogDto dto);

    ActivityLogDto toDto(ActivityLog entity);
}
