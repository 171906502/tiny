package com.zch.tiny.controller;

import com.zch.tiny.dto.ScheduledTaskDto;
import com.zch.tiny.model.ScheduledTask;
import com.zch.tiny.service.ScheduledTaskService;
import com.zch.tiny.mapper.ScheduledTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scheduledTasks")
public class ScheduledTaskController {

    @Autowired
    private ScheduledTaskService service;

    private final ScheduledTaskMapper mapper = ScheduledTaskMapper.INSTANCE;

    @GetMapping
    public List<ScheduledTaskDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ScheduledTaskDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public ScheduledTaskDto save(@RequestBody ScheduledTaskDto dto) {
        ScheduledTask entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<ScheduledTaskDto> findByExample(@RequestBody ScheduledTaskDto dto) {
        ScheduledTask example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
