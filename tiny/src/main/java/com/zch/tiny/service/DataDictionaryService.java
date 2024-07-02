package com.zch.tiny.service;

import com.zch.tiny.model.DataDictionary;
import com.zch.tiny.repository.DataDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataDictionaryService {

    @Autowired
    private DataDictionaryRepository repository;

    public List<DataDictionary> findAll() {
        return repository.findAll();
    }

    public Optional<DataDictionary> findById(Integer id) {
        return repository.findById(id);
    }

    public DataDictionary save(DataDictionary entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<DataDictionary> findByExample(DataDictionary example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
