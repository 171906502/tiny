package com.zch.tiny.service;

import com.zch.tiny.model.UserRole;
import com.zch.tiny.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository repository;

    public List<UserRole> findAll() {
        return repository.findAll();
    }



    public List<UserRole> findByExample(UserRole example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
