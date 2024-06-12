package com.zch.tiny.mapper;

import com.zch.tiny.model.TaskSchedule;
import com.zch.tiny.dto.TaskScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskScheduleMapper {
    TaskScheduleMapper INSTANCE = Mappers.getMapper(TaskScheduleMapper.class);

    TaskSchedule toEntity(TaskScheduleDto dto);

    TaskScheduleDto toDto(TaskSchedule entity);
}
