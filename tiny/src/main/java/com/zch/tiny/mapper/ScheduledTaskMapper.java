package com.zch.tiny.mapper;

import com.zch.tiny.model.ScheduledTask;
import com.zch.tiny.dto.ScheduledTaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduledTaskMapper {
    ScheduledTaskMapper INSTANCE = Mappers.getMapper(ScheduledTaskMapper.class);

    ScheduledTask toEntity(ScheduledTaskDto dto);

    ScheduledTaskDto toDto(ScheduledTask entity);
}
