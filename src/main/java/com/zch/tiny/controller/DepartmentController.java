package com.zch.tiny.controller;

import com.zch.tiny.dto.DepartmentDto;
import com.zch.tiny.model.Department;
import com.zch.tiny.service.DepartmentService;
import com.zch.tiny.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    private final DepartmentMapper mapper = DepartmentMapper.INSTANCE;

    @GetMapping
    public List<DepartmentDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<DepartmentDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public DepartmentDto save(@RequestBody DepartmentDto dto) {
        Department entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<DepartmentDto> findByExample(@RequestBody DepartmentDto dto) {
        Department example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
