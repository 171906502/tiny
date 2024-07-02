package com.zch.tiny.controller;

import com.zch.tiny.dto.ApiRequestLogDto;
import com.zch.tiny.model.ApiRequestLog;
import com.zch.tiny.service.ApiRequestLogService;
import com.zch.tiny.mapper.ApiRequestLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apiRequestLogs")
public class ApiRequestLogController {

    @Autowired
    private ApiRequestLogService service;

    private final ApiRequestLogMapper mapper = ApiRequestLogMapper.INSTANCE;

    @GetMapping
    public List<ApiRequestLogDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ApiRequestLogDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public ApiRequestLogDto save(@RequestBody ApiRequestLogDto dto) {
        ApiRequestLog entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<ApiRequestLogDto> findByExample(@RequestBody ApiRequestLogDto dto) {
        ApiRequestLog example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
