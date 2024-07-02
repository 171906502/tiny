package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class DataDictionaryDto {

    private Integer dictionaryId;    
    private String dictType;    
    private String dictKey;    
    private String dictValue;    
    private String description;    
    private LocalDateTime createdAt;    
    private LocalDateTime updatedAt;    

}
