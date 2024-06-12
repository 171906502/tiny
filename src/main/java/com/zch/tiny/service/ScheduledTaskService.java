package com.zch.tiny.service;

import com.zch.tiny.model.ScheduledTask;
import com.zch.tiny.repository.ScheduledTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduledTaskService {

    @Autowired
    private ScheduledTaskRepository repository;

    public List<ScheduledTask> findAll() {
        return repository.findAll();
    }

    public Optional<ScheduledTask> findById(Long id) {
        return repository.findById(id);
    }

    public ScheduledTask save(ScheduledTask entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<ScheduledTask> findByExample(ScheduledTask example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
