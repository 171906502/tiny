package com.zch.tiny.service;

import com.zch.tiny.model.UserDepartment;
import com.zch.tiny.repository.UserDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDepartmentService {

    @Autowired
    private UserDepartmentRepository repository;

    public List<UserDepartment> findAll() {
        return repository.findAll();
    }

    public Optional<UserDepartment> findById(Integer id) {
        return repository.findById(id);
    }

    public UserDepartment save(UserDepartment entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<UserDepartment> findByExample(UserDepartment example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
