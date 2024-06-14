package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class DataDictionaryDto {

    private Integer dictionary_id;
    
    private String dict_type;
    
    private String dict_key;
    
    private String dict_value;
    
    private String description;
    
    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;
    

}
