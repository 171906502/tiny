package com.zch.tiny.controller;

import com.zch.tiny.dto.UserRoleDto;
import com.zch.tiny.model.UserRole;
import com.zch.tiny.service.UserRoleService;
import com.zch.tiny.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userRoles")
public class UserRoleController {

    @Autowired
    private UserRoleService service;

    private final UserRoleMapper mapper = UserRoleMapper.INSTANCE;

    @GetMapping
    public List<UserRoleDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<UserRoleDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public UserRoleDto save(@RequestBody UserRoleDto dto) {
        UserRole entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<UserRoleDto> findByExample(@RequestBody UserRoleDto dto) {
        UserRole example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
