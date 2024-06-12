package com.zch.tiny.controller;

import com.zch.tiny.dto.DataDictionaryDto;
import com.zch.tiny.model.DataDictionary;
import com.zch.tiny.service.DataDictionaryService;
import com.zch.tiny.mapper.DataDictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dataDictionarys")
public class DataDictionaryController {

    @Autowired
    private DataDictionaryService service;

    private final DataDictionaryMapper mapper = DataDictionaryMapper.INSTANCE;

    @GetMapping
    public List<DataDictionaryDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<DataDictionaryDto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public DataDictionaryDto save(@RequestBody DataDictionaryDto dto) {
        DataDictionary entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<DataDictionaryDto> findByExample(@RequestBody DataDictionaryDto dto) {
        DataDictionary example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
