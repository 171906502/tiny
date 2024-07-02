package com.zch.tiny.controller;

import com.zch.tiny.dto.NotificationDto;
import com.zch.tiny.model.Notification;
import com.zch.tiny.service.NotificationService;
import com.zch.tiny.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    private final NotificationMapper mapper = NotificationMapper.INSTANCE;

    @GetMapping
    public List<NotificationDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<NotificationDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public NotificationDto save(@RequestBody NotificationDto dto) {
        Notification entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<NotificationDto> findByExample(@RequestBody NotificationDto dto) {
        Notification example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
