package com.zch.tiny.mapper;

import com.zch.tiny.model.DataDictionary;
import com.zch.tiny.dto.DataDictionaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DataDictionaryMapper {
    DataDictionaryMapper INSTANCE = Mappers.getMapper(DataDictionaryMapper.class);

    DataDictionary toEntity(DataDictionaryDto dto);

    DataDictionaryDto toDto(DataDictionary entity);
}
