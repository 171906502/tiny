package com.zch.tiny.controller;

import com.zch.tiny.dto.AccessLogDto;
import com.zch.tiny.model.AccessLog;
import com.zch.tiny.service.AccessLogService;
import com.zch.tiny.mapper.AccessLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accessLogs")
public class AccessLogController {

    @Autowired
    private AccessLogService service;

    private final AccessLogMapper mapper = AccessLogMapper.INSTANCE;

    @GetMapping
    public List<AccessLogDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<AccessLogDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public AccessLogDto save(@RequestBody AccessLogDto dto) {
        AccessLog entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<AccessLogDto> findByExample(@RequestBody AccessLogDto dto) {
        AccessLog example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
