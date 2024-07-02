package com.zch.tiny.mapper;

import com.zch.tiny.model.Notification;
import com.zch.tiny.dto.NotificationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    Notification toEntity(NotificationDto dto);

    NotificationDto toDto(Notification entity);
}
