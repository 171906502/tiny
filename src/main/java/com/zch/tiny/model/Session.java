package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue
    private String sessionId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "user_agent")
    private String userAgent;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;


}
