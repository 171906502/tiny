package com.zch.tiny.controller;

import com.zch.tiny.dto.SessionDto;
import com.zch.tiny.model.Session;
import com.zch.tiny.service.SessionService;
import com.zch.tiny.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService service;

    private final SessionMapper mapper = SessionMapper.INSTANCE;

    @GetMapping
    public List<SessionDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<SessionDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public SessionDto save(@RequestBody SessionDto dto) {
        Session entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<SessionDto> findByExample(@RequestBody SessionDto dto) {
        Session example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
