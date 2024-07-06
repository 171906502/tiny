package com.zch.tiny.model;

import jakarta.persistence.*;
import java.time.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "system_config")
public class SystemConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer configId;
    
    @Column(name = "config_key")
    private String configKey;
    
    @Column(name = "config_value")
    private String configValue;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    


}
