package com.zch.tiny.controller;

import com.zch.tiny.dto.ActivityLogDto;
import com.zch.tiny.model.ActivityLog;
import com.zch.tiny.service.ActivityLogService;
import com.zch.tiny.mapper.ActivityLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/activityLogs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService service;

    private final ActivityLogMapper mapper = ActivityLogMapper.INSTANCE;

    @GetMapping
    public List<ActivityLogDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ActivityLogDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public ActivityLogDto save(@RequestBody ActivityLogDto dto) {
        ActivityLog entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<ActivityLogDto> findByExample(@RequestBody ActivityLogDto dto) {
        ActivityLog example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
