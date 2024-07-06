package com.zch.embd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public void createUserWithRolesAndPermissions() {
        User user = new User();
        user.setUsername("john_doe");
        userRepository.save(user);

        Role role = new Role();
        role.setName("ADMIN");
        roleRepository.save(role);

        Permission permission = new Permission();
        permission.setName("READ_PRIVILEGES");
        permissionRepository.save(permission);

        // Assign role to user
        UserRole userRole = new UserRole();
        UserRoleKey userRoleKey = new UserRoleKey();
        userRoleKey.setUserId(user.getId());
        userRoleKey.setRoleId(role.getId());
        userRole.setId(userRoleKey);
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);

        // Assign permission to role
        RolePermission rolePermission = new RolePermission();
        RolePermissionKey rolePermissionKey = new RolePermissionKey();
        rolePermissionKey.setRoleId(role.getId());
        rolePermissionKey.setPermissionId(permission.getId());
        rolePermission.setId(rolePermissionKey);
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);
        rolePermissionRepository.save(rolePermission);
    }


    public void updateUserRoles() {
        Role r2 = new Role();
        r2.setId(2L);
        r2.setName("role 2");
        roleRepository.save(r2);

        Role r3 = new Role();
        r3.setId(3L);
        r3.setName("role 3");
        roleRepository.save(r3);


        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
        Role role1 = roleRepository.findById(1L).orElseThrow(() -> new RuntimeException("Role not found"));
        Role role2 = roleRepository.findById(2L).orElseThrow(() -> new RuntimeException("Role not found"));

        // Add roles
        user.addRole(role1);
        user.addRole(role2);
        
        userRepository.save(user);

        // Remove a role
        user.removeRole(role1);
        
        userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

}
