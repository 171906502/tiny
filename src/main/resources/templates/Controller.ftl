package ${packageName};

import ${packageName?substring(0, packageName?last_index_of('.'))}.dto.${className}Dto;
import ${packageName?substring(0, packageName?last_index_of('.'))}.model.${className};
import ${packageName?substring(0, packageName?last_index_of('.'))}.service.${className}Service;
import ${packageName?substring(0, packageName?last_index_of('.'))}.mapper.${className}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/${className?uncap_first}s")
public class ${className}Controller {

    @Autowired
    private ${className}Service service;

    private final ${className}Mapper mapper = ${className}Mapper.INSTANCE;

    @GetMapping
    public List<${className}Dto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<${className}Dto> findById(@PathVariable Long id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public ${className}Dto save(@RequestBody ${className}Dto dto) {
        ${className} entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<${className}Dto> findByExample(@RequestBody ${className}Dto dto) {
        ${className} example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
