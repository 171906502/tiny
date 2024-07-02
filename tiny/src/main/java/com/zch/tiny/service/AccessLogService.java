package com.zch.tiny.service;

import com.zch.tiny.model.AccessLog;
import com.zch.tiny.repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLogService {

    @Autowired
    private AccessLogRepository repository;

    public List<AccessLog> findAll() {
        return repository.findAll();
    }

    public Optional<AccessLog> findById(Integer id) {
        return repository.findById(id);
    }

    public AccessLog save(AccessLog entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<AccessLog> findByExample(AccessLog example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
