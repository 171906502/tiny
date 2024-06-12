package com.zch.tiny.mapper;

import com.zch.tiny.model.SystemConfig;
import com.zch.tiny.dto.SystemConfigDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemConfigMapper {
    SystemConfigMapper INSTANCE = Mappers.getMapper(SystemConfigMapper.class);

    SystemConfig toEntity(SystemConfigDto dto);

    SystemConfigDto toDto(SystemConfig entity);
}
