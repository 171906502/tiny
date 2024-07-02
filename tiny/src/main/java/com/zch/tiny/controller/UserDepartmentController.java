package com.zch.tiny.controller;

import com.zch.tiny.dto.UserDepartmentDto;
import com.zch.tiny.model.UserDepartment;
import com.zch.tiny.service.UserDepartmentService;
import com.zch.tiny.mapper.UserDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userDepartments")
public class UserDepartmentController {

    @Autowired
    private UserDepartmentService service;

    private final UserDepartmentMapper mapper = UserDepartmentMapper.INSTANCE;

    @GetMapping
    public List<UserDepartmentDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<UserDepartmentDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public UserDepartmentDto save(@RequestBody UserDepartmentDto dto) {
        UserDepartment entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<UserDepartmentDto> findByExample(@RequestBody UserDepartmentDto dto) {
        UserDepartment example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
