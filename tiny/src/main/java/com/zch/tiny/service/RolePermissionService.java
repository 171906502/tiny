package com.zch.tiny.service;

import com.zch.tiny.model.RolePermission;
import com.zch.tiny.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionRepository repository;

    public List<RolePermission> findAll() {
        return repository.findAll();
    }

    public Optional<RolePermission> findById(Integer id) {
        return repository.findById(id);
    }

    public RolePermission save(RolePermission entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<RolePermission> findByExample(RolePermission example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
