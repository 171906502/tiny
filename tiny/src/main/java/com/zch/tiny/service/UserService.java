package com.zch.tiny.service;

import com.zch.tiny.Exception.ResourceNotFoundException;
import com.zch.tiny.dto.UserDto;
import com.zch.tiny.model.*;
import com.zch.tiny.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDepartmentRepository userDepartmentRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public User createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void assignUserToDepartment(Integer userId, Integer departmentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setId(new UserDepartmentId(userId, departmentId));
        userDepartment.setUser(user);
        userDepartment.setDepartment(department);

        userDepartmentRepository.save(userDepartment);
    }

    public void assignUserToRole(Integer userId, Integer roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        UserRole userRole = new UserRole();
        userRole.setId(new UserRoleId(userId, roleId));
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepository.save(userRole);
    }

    public Optional<UserDto> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
