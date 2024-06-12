package com.zch.tiny.controller;

import com.zch.tiny.dto.RolePermissionDto;
import com.zch.tiny.model.RolePermission;
import com.zch.tiny.service.RolePermissionService;
import com.zch.tiny.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rolePermissions")
public class RolePermissionController {

    @Autowired
    private RolePermissionService service;

    private final RolePermissionMapper mapper = RolePermissionMapper.INSTANCE;

    @GetMapping
    public List<RolePermissionDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<RolePermissionDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public RolePermissionDto save(@RequestBody RolePermissionDto dto) {
        RolePermission entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<RolePermissionDto> findByExample(@RequestBody RolePermissionDto dto) {
        RolePermission example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
