 package com.zch.tiny.controller;

 import com.zch.tiny.dto.UserDto;
import com.zch.tiny.mapper.CycleAvoidingMappingContext;
import com.zch.tiny.mapper.PermissionMapper;
 import com.zch.tiny.mapper.UserMapper;
 import com.zch.tiny.model.User;
 import com.zch.tiny.service.UserService;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.validation.annotation.Validated;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;
 import java.util.Optional;
 @RestController
 @RequestMapping("/api/users")
 public class UserController {
     @Autowired
     private UserService userService;

     private final UserMapper userMapper = UserMapper.INSTANCE;

     @PostMapping
     public ResponseEntity<User> createUser(@Validated @RequestBody UserDto user) throws BadRequestException {
         User createdUser = userService.createUser(userMapper.toEntity(user,new CycleAvoidingMappingContext()));
         return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
     }

     @PutMapping("/{id}")
     public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
         user.setUserId(id);
         User updatedUser = userService.updateUser(user);
         return ResponseEntity.ok(updatedUser);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
         userService.deleteUser(id);
         return ResponseEntity.noContent().build();
     }

     @GetMapping("/{id}")
     public ResponseEntity<User> getUserById(@PathVariable Integer id) {
         Optional<User> user = userService.getUserById(id);
         var u =user.get();
        //  return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        return ResponseEntity.ok(u);
     }

     @GetMapping
     public ResponseEntity<List<User>> getAllUsers() {
         List<User> users = userService.getAllUsers();
         return ResponseEntity.ok(users);
     }

     @PostMapping("/{id}/departments/{departmentId}")
     public ResponseEntity<Void> assignUserToDepartment(@PathVariable Integer id, @PathVariable Integer departmentId) {
         userService.assignUserToDepartment(id, departmentId);
         return ResponseEntity.noContent().build();
     }

     @PostMapping("/{id}/roles/{roleId}")
     public ResponseEntity<Void> assignUserToRole(@PathVariable Integer id, @PathVariable Integer roleId) {
         userService.assignRoleToUser(id, roleId);
         return ResponseEntity.noContent().build();
     }
 }
