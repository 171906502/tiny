package com.zch.tiny.controller;

import com.zch.tiny.dto.MenuDto;
import com.zch.tiny.model.Menu;
import com.zch.tiny.service.MenuService;
import com.zch.tiny.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService service;

    private final MenuMapper mapper = MenuMapper.INSTANCE;

    @GetMapping
    public List<MenuDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<MenuDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public MenuDto save(@RequestBody MenuDto dto) {
        Menu entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<MenuDto> findByExample(@RequestBody MenuDto dto) {
        Menu example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
