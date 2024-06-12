package com.zch.tiny.service;

import com.zch.tiny.model.File;
import com.zch.tiny.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository repository;

    public List<File> findAll() {
        return repository.findAll();
    }

    public Optional<File> findById(Long id) {
        return repository.findById(id);
    }

    public File save(File entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<File> findByExample(File example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
