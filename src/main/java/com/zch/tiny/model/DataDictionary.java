package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "data_dictionary")
public class DataDictionary {

    @Id
    @GeneratedValue
    private Integer dictionaryId;
    
    @Column(name = "dict_type")
    private String dictType;
    
    @Column(name = "dict_key")
    private String dictKey;
    
    @Column(name = "dict_value")
    private String dictValue;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    


}
