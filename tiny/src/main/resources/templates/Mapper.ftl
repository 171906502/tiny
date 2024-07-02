package ${packageName};

import ${packageName?substring(0, packageName?last_index_of('.'))}.model.${className};
import ${packageName?substring(0, packageName?last_index_of('.'))}.dto.${className}Dto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ${className}Mapper {
    ${className}Mapper INSTANCE = Mappers.getMapper(${className}Mapper.class);

    ${className} toEntity(${className}Dto dto);

    ${className}Dto toDto(${className} entity);
}
