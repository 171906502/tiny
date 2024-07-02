package com.zch.tiny.controller;

import com.zch.tiny.dto.OperationLogDto;
import com.zch.tiny.model.OperationLog;
import com.zch.tiny.service.OperationLogService;
import com.zch.tiny.mapper.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operationLogs")
public class OperationLogController {

    @Autowired
    private OperationLogService service;

    private final OperationLogMapper mapper = OperationLogMapper.INSTANCE;

    @GetMapping
    public List<OperationLogDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<OperationLogDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public OperationLogDto save(@RequestBody OperationLogDto dto) {
        OperationLog entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<OperationLogDto> findByExample(@RequestBody OperationLogDto dto) {
        OperationLog example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
