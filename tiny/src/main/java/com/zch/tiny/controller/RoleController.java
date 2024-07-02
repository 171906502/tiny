package com.zch.tiny.controller;

import com.zch.tiny.dto.RoleDto;
import com.zch.tiny.model.Role;
import com.zch.tiny.service.RoleService;
import com.zch.tiny.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    private final RoleMapper mapper = RoleMapper.INSTANCE;

    @GetMapping
    public List<RoleDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<RoleDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public RoleDto save(@RequestBody RoleDto dto) {
        Role entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<RoleDto> findByExample(@RequestBody RoleDto dto) {
        Role example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
