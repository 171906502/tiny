package com.zch.tiny.model;

import jakarta.persistence.*;

import java.time.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "access_log")
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accessId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "ip_address")
    private String ipAddress;
    
    @Column(name = "request_url")
    private String requestUrl;
    
    @Column(name = "request_method")
    private String requestMethod;
    
    @Column(name = "response_status")
    private Integer responseStatus;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    


}
