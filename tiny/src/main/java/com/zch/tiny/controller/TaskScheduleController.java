package com.zch.tiny.controller;

import com.zch.tiny.dto.TaskScheduleDto;
import com.zch.tiny.model.TaskSchedule;
import com.zch.tiny.service.TaskScheduleService;
import com.zch.tiny.mapper.TaskScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/taskSchedules")
public class TaskScheduleController {

    @Autowired
    private TaskScheduleService service;

    private final TaskScheduleMapper mapper = TaskScheduleMapper.INSTANCE;

    @GetMapping
    public List<TaskScheduleDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<TaskScheduleDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public TaskScheduleDto save(@RequestBody TaskScheduleDto dto) {
        TaskSchedule entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<TaskScheduleDto> findByExample(@RequestBody TaskScheduleDto dto) {
        TaskSchedule example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
