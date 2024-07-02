package com.zch.tiny.service;

import com.zch.tiny.model.Permission;
import com.zch.tiny.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository repository;

    public List<Permission> findAll() {
        return repository.findAll();
    }

    public Optional<Permission> findById(Long id) {
        return repository.findById(id);
    }

    public Permission save(Permission entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Permission> findByExample(Permission example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
