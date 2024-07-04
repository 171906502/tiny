package com.zch.tiny.repository;

import com.zch.tiny.model.Department;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByParentId(int parentId);
    Optional<Department> findByDepartmentName(String departmentName);
}
