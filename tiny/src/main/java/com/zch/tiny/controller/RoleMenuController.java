package com.zch.tiny.controller;

import com.zch.tiny.dto.RoleMenuDto;
import com.zch.tiny.model.RoleMenu;
import com.zch.tiny.service.RoleMenuService;
import com.zch.tiny.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rolePermissions")
public class RoleMenuController {

    @Autowired
    private RoleMenuService service;

    private final RoleMenuMapper mapper = RoleMenuMapper.INSTANCE;

    @GetMapping
    public List<RoleMenuDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // @GetMapping("/{id}")
    // public Optional<RoleMenuDto> findById(@PathVariable Integer id) {
    //     return service.findById(id).map(mapper::toDto);
    // }

    @PostMapping
    public RoleMenuDto save(@RequestBody RoleMenuDto dto) {
        RoleMenu entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{roleId}/{menuId}")
    public void deleteById(@PathVariable Integer roleId,@PathVariable Integer menuId) {
        service.deleteById(roleId,menuId);
    }

    @PostMapping("/search")
    public List<RoleMenuDto> findByExample(@RequestBody RoleMenuDto dto) {
        RoleMenu example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
