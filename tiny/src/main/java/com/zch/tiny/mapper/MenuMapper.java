package com.zch.tiny.mapper;

import com.zch.tiny.model.Menu;
import com.zch.tiny.dto.MenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {
    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    Menu toEntity(MenuDto dto);

    MenuDto toDto(Menu entity);
}
