package com.zch.tiny.controller;

import com.zch.tiny.model.Department;
import com.zch.tiny.service.DepartmentService;
import com.zch.tiny.dto.DepartmentDto;
import com.zch.tiny.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final DepartmentMapper mapper = DepartmentMapper.INSTANCE;

    @GetMapping
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        Optional<Department> department = departmentService.findById(id);
        if (department.isPresent()) {
            return ResponseEntity.ok(department.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/parent/{parentId}")
    public List<Department> getDepartmentsByParentId(@PathVariable int parentId) {
        return departmentService.findByParentId(parentId);
    }

    @PostMapping
    public Department createDepartment(@RequestBody DepartmentDto department) {
        return departmentService.save(mapper.toEntity(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody DepartmentDto departmentDetails) {
        try {
            Department updatedDepartment = departmentService.update(id, mapper.toEntity(departmentDetails));
            return ResponseEntity.ok(updatedDepartment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
        if (departmentService.findById(id).isPresent()) {
            departmentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tree")
    public List<Department> getDepartmentTree() {
        return departmentService.buildDepartmentTree();
    }
}