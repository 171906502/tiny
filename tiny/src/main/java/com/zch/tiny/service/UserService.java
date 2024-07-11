package com.zch.tiny.service;

import com.zch.tiny.dto.UserDto;
import com.zch.tiny.exception.ResourceNotFoundException;
import com.zch.tiny.help.BeanUtils;
import com.zch.tiny.model.*;
import com.zch.tiny.repository.*;

import lombok.extern.slf4j.Slf4j;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    public User createUser(User user) throws BadRequestException {
        if(user.getUserId()!=null){
            throw new BadRequestException(String.format("新增用户id必须为空,提交值为:%d", user.getUserId()));
        }
        validateUsernameUniqueness(user.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        //允许用户同时编辑部门和角色信息
        user.getUserDepartments().forEach(ud->{
            var dep = departmentRepository.findById(ud.getId().getDepartmentId());
            ud.setDepartment(dep.get());
        });
        user.getUserRoles().forEach(ur->{
            var r = roleRepository.findById(ur.getUserRoleId().getRoleId());
            ur.setRole(r.get());
        });
        return userRepository.save(user);
    }

    public User updateUser(User updateUser) {
        // 如果 updateUser.userRoles,updateUser.userDepartments 都为空可以直接保存
        // 如果userRepository.findById实例化user后不能直接set null。
        // 要移除集合必须通过remove或者clear
        var user = userRepository.findById(updateUser.getUserId()).get();
        //不同时更新部门和角色
        updateUser.setUserDepartments(null);
        updateUser.setUserRoles(null);
        BeanUtils.copyPropertiesWithoutNull(updateUser,user);
        validateUsernameUniqueness(user.getUsername(),user.getUserId());
        // user.getUserRoles().clear();
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

    // 一对多或者多对多，两种更新方式，级联更新
    public void assignUserToDepartment(Integer userId, Integer departmentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        user.addDepartment(department);
        userRepository.save(user);
    }

    // 一对多或者多对多，两种更新方式，单独保存中间表
    public void assignRoleToUser(int userId, int roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        UserRoleId key = new UserRoleId();
        key.setUserId(user.getUserId());
        key.setRoleId(role.getRoleId());
        boolean exists = userRoleRepository.existsById(key);
        if (!exists) {
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRole.setUserRoleId(key);
            userRoleRepository.save(userRole);
        }
        // userRepository.save(user);
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
        if (existingUser.isPresent() && existingUser.get().getUserId() != userId) {
            throw new RuntimeException("Username already exists");
        }
    }

    public Optional<UserDto> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
