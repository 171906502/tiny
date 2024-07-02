package com.zch.tiny.mapper;

import com.zch.tiny.model.OperationLog;
import com.zch.tiny.dto.OperationLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationLogMapper {
    OperationLogMapper INSTANCE = Mappers.getMapper(OperationLogMapper.class);

    OperationLog toEntity(OperationLogDto dto);

    OperationLogDto toDto(OperationLog entity);
}
