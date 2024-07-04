package com.zch.tiny.service;

import com.zch.tiny.model.Department;
import com.zch.tiny.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(int id) {
        return departmentRepository.findById(id);
    }

    public List<Department> findByParentId(int parentId) {
        return departmentRepository.findByParentId(parentId);
    }

    public Department save(Department department) {
        validateParentId(department.getParentId());
        validateUniqueDepartmentName(department.getDepartmentName(), department.getDepartmentId());
        return departmentRepository.save(department);
    }

    public Department update(int id, Department departmentDetails) {
        validateParentId(departmentDetails.getParentId());
        validateUniqueDepartmentName(departmentDetails.getDepartmentName(), id);
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            Department updatedDepartment = department.get();
            updatedDepartment.setDepartmentName(departmentDetails.getDepartmentName());
            updatedDepartment.setDescription(departmentDetails.getDescription());
            updatedDepartment.setParentId(departmentDetails.getParentId());
            updatedDepartment.setStatus(departmentDetails.getStatus());
            return departmentRepository.save(updatedDepartment);
        } else {
            throw new IllegalArgumentException("Department not found");
        }
    }

    public void deleteById(int id) {
        departmentRepository.deleteById(id);
    }

    public List<Department> buildDepartmentTree() {
        List<Department> departments = departmentRepository.findAll();
        Map<Integer, Department> departmentMap = new HashMap<>();

        for (Department department : departments) {
            departmentMap.put(department.getDepartmentId(), department);
            department.setChildren(new ArrayList<>());
        }

        List<Department> rootDepartments = new ArrayList<>();

        for (Department department : departments) {
            if (department.getParentId().equals(0)) {
                rootDepartments.add(department);
            } else {
                Department parent = departmentMap.get(department.getParentId());
                if (parent != null) {
                    parent.getChildren().add(department);
                }
            }
        }

        return rootDepartments;
    }

    private void validateParentId(int parentId) {
        if (parentId != 0 && !departmentRepository.existsById(parentId)) {
            throw new IllegalArgumentException("Parent department does not exist");
        }
    }

    private void validateUniqueDepartmentName(String departmentName, Integer departmentId) {
        Optional<Department> existingDepartment = departmentRepository.findByDepartmentName(departmentName);
        if (existingDepartment.isPresent() && !existingDepartment.get().getDepartmentId().equals(departmentId)) {
            throw new IllegalArgumentException("Department name must be unique");
        }
    }
}
