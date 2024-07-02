package com.zch.tiny.service;

import com.zch.tiny.model.OperationLog;
import com.zch.tiny.repository.OperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationLogService {

    @Autowired
    private OperationLogRepository repository;

    public List<OperationLog> findAll() {
        return repository.findAll();
    }

    public Optional<OperationLog> findById(Integer id) {
        return repository.findById(id);
    }

    public OperationLog save(OperationLog entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<OperationLog> findByExample(OperationLog example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
