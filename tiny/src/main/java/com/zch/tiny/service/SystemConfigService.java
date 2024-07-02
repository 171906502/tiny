package com.zch.tiny.service;

import com.zch.tiny.model.SystemConfig;
import com.zch.tiny.repository.SystemConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemConfigService {

    @Autowired
    private SystemConfigRepository repository;

    public List<SystemConfig> findAll() {
        return repository.findAll();
    }

    public Optional<SystemConfig> findById(Integer id) {
        return repository.findById(id);
    }

    public SystemConfig save(SystemConfig entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<SystemConfig> findByExample(SystemConfig example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
