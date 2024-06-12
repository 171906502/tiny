package com.zch.tiny.service;

import com.zch.tiny.model.Session;
import com.zch.tiny.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository repository;

    public List<Session> findAll() {
        return repository.findAll();
    }

    public Optional<Session> findById(Long id) {
        return repository.findById(id);
    }

    public Session save(Session entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Session> findByExample(Session example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
