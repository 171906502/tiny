package com.zch.tiny.service;

import com.zch.tiny.model.Menu;
import com.zch.tiny.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repository;

    public List<Menu> findAll() {
        return repository.findAll();
    }

    public Optional<Menu> findById(Long id) {
        return repository.findById(id);
    }

    public Menu save(Menu entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Menu> findByExample(Menu example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
