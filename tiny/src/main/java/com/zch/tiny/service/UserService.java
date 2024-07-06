package com.zch.tiny.service;

import com.zch.tiny.Exception.ResourceNotFoundException;
import com.zch.tiny.dto.UserDto;
import com.zch.tiny.help.BeanUtils;
import com.zch.tiny.model.*;
import com.zch.tiny.repository.*;

import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public User createUser(User user) {
        validateUsernameUniqueness(user.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User updateUser) {
        var user = userRepository.findById(updateUser.getId()).get();
        BeanUtils.copyPropertiesWithoutNull(user,updateUser);
        validateUsernameUniqueness(user.getUsername(),user.getId());
        return userRepository.save(user);
    }
    

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        User u2 = userRepository.findById(Integer.valueOf(1)).get();
        // log.info(u2.getUserRoles().toString());
        u2.addRole(roleRepository.findById(1).get());
        u2= userRepository.save(u2);
        // log.info(u2.getUserRoles().toString());
        var ll = userRepository.findAll();
        ll.forEach(e->{
            e.getUserRoles();
        });
        return ll;
    }

    public void assignUserToDepartment(Integer userId, Integer departmentId) {
        // User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // Department department = departmentRepository.findById(departmentId)
        //         .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        // UserDepartment userDepartment = new UserDepartment();
        // userDepartment.setId(new UserDepartmentId(userId, departmentId));
        // userDepartment.setUser(user);
        // userDepartment.setDepartment(department);

        // userDepartmentRepository.save(userDepartment);
    }

    public void assignRoleToUser(int userId, int roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));

        // user.getUserRoles().stream().forEach(userRole->{
        //     if(userRole.getRole().getRoleId().equals(roleId)){
        //         throw new RuntimeException("User already has this role assigned");
        //     }
        // });
        // var ur = new UserRole();
        // ur.setUser(user);
        // ur.setRole(role);
        // user.getUserRoles().add(ur);
        userRepository.save(user);
    }

    public void revokeRoleFromUser(int userId, int roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        // var urSet = user.getUserRoles().stream().filter(userRole->{return userRole.getRole().getRoleId().equals(roleId);}).collect(Collectors.toSet());
        // user.setUserRoles(urSet);
        // userRepository.save(user);
    }

    private void validateUsernameUniqueness(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
    }

    private void validateUsernameUniqueness(String username, int userId) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent() && existingUser.get().getId() != userId) {
            throw new RuntimeException("Username already exists");
        }
    }

    public Optional<UserDto> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
