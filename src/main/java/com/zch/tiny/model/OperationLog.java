package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "operation_log")
public class OperationLog {

    @Id
    @GeneratedValue
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
