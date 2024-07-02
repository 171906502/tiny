package com.zch.tiny.mapper;

import com.zch.tiny.model.File;
import com.zch.tiny.dto.FileDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    File toEntity(FileDto dto);

    FileDto toDto(File entity);
}
