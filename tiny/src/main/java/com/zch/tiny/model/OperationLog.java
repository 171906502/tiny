package com.zch.tiny.model;

import jakarta.persistence.*;
import java.time.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "operation_log")
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "operation")
    private String operation;
    
    @Column(name = "ip_address")
    private String ipAddress;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    


}
