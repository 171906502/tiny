package com.zch.tiny.controller;

import com.zch.tiny.dto.PermissionDto;
import com.zch.tiny.model.Permission;
import com.zch.tiny.service.PermissionService;
import com.zch.tiny.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService service;

    private final PermissionMapper mapper = PermissionMapper.INSTANCE;

    @GetMapping
    public List<PermissionDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<PermissionDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public PermissionDto save(@RequestBody PermissionDto dto) {
        Permission entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<PermissionDto> findByExample(@RequestBody PermissionDto dto) {
        Permission example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
