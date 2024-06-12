package com.zch.tiny.service;

import com.zch.tiny.model.Notification;
import com.zch.tiny.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public List<Notification> findAll() {
        return repository.findAll();
    }

    public Optional<Notification> findById(Long id) {
        return repository.findById(id);
    }

    public Notification save(Notification entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Notification> findByExample(Notification example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
