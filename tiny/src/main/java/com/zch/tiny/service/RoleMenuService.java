package com.zch.tiny.service;

import com.zch.tiny.model.RoleMenu;
import com.zch.tiny.model.RoleMenuId;
import com.zch.tiny.repository.RoleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleMenuService {

    @Autowired
    private RoleMenuRepository repository;

    public List<RoleMenu> findAll() {
        return repository.findAll();
    }

    public Optional<RoleMenu> findById(Integer roleId,Integer menuId) {
        var id = new RoleMenuId(roleId,menuId);
        return repository.findById(id);
    }

    public RoleMenu save(RoleMenu entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer roleId,Integer menuId) {
        repository.deleteById(new RoleMenuId(roleId,menuId));
    }

    public List<RoleMenu> findByExample(RoleMenu example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }
}
