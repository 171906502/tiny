package com.zch.tiny.service;

import com.zch.tiny.model.TaskSchedule;
import com.zch.tiny.repository.TaskScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskScheduleService {

    @Autowired
    private TaskScheduleRepository repository;

    public List<TaskSchedule> findAll() {
        return repository.findAll();
    }

    public Optional<TaskSchedule> findById(Integer id) {
        return repository.findById(id);
    }

    public TaskSchedule save(TaskSchedule entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<TaskSchedule> findByExample(TaskSchedule example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
