package com.zch.tiny.service;

import com.zch.tiny.model.Role;
import com.zch.tiny.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Optional<Role> findById(Integer id) {
        return repository.findById(id);
    }

    public Role carete(Role entity) {
        entity.setRoleId(null);
        validateRoleNameUniqueness(entity.getRoleName());
        return repository.save(entity);
    }

    public Role update(Role entity) {
        validateRoleNameUniqueness(entity.getRoleName(), entity.getRoleId());
        return repository.save(entity);
    }


    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<Role> findByExample(Role example) {
        // Custom query logic to find entities by example fields
        // This is a placeholder, you can implement a more sophisticated example query
        return repository.findAll();
    }

    private void validateRoleNameUniqueness(String roleName) {
        var r = new Role();
        r.setRoleName(roleName);
        if (repository.findOne(Example.of(r)).isPresent()) {
            throw new RuntimeException("role name already exists");
        }
    }

   
    private void validateRoleNameUniqueness(String roleName, Integer roleId) {
        var r = new Role();
        r.setRoleName(roleName);
        Optional<Role> existingRole = repository.findOne(Example.of(r));
        if (existingRole.isPresent() && existingRole.get().getRoleId() != roleId) {
            throw new RuntimeException("role name already exists");
        }
    }
}
/**
 * 在使用spring security的项目中，我要实现全项目目录扫描使用PreAuthorize的controller类的函数。读取controller的名称，方法名称，PreAuthorize的注解参数等关键信息
 * 生成json对象，保存在全局的内存对象中，
 * 
 */