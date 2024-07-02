package com.zch.tiny.controller;

import com.zch.tiny.dto.SystemConfigDto;
import com.zch.tiny.model.SystemConfig;
import com.zch.tiny.service.SystemConfigService;
import com.zch.tiny.mapper.SystemConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/systemConfigs")
public class SystemConfigController {

    @Autowired
    private SystemConfigService service;

    private final SystemConfigMapper mapper = SystemConfigMapper.INSTANCE;

    @GetMapping
    public List<SystemConfigDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<SystemConfigDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public SystemConfigDto save(@RequestBody SystemConfigDto dto) {
        SystemConfig entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<SystemConfigDto> findByExample(@RequestBody SystemConfigDto dto) {
        SystemConfig example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
