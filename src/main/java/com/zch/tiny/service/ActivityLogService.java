package com.zch.tiny.service;

import com.zch.tiny.model.ActivityLog;
import com.zch.tiny.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogService {

    @Autowired
    private ActivityLogRepository repository;

    public List<ActivityLog> findAll() {
        return repository.findAll();
    }

    public Optional<ActivityLog> findById(Long id) {
        return repository.findById(id);
    }

    public ActivityLog save(ActivityLog entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<ActivityLog> findByExample(ActivityLog example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
