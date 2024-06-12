package com.zch.tiny.service;

import com.zch.tiny.model.ApiRequestLog;
import com.zch.tiny.repository.ApiRequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiRequestLogService {

    @Autowired
    private ApiRequestLogRepository repository;

    public List<ApiRequestLog> findAll() {
        return repository.findAll();
    }

    public Optional<ApiRequestLog> findById(Long id) {
        return repository.findById(id);
    }

    public ApiRequestLog save(ApiRequestLog entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<ApiRequestLog> findByExample(ApiRequestLog example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
