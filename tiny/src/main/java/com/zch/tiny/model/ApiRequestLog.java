package com.zch.tiny.model;

import jakarta.persistence.*;
import java.time.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "api_request_log")
public class ApiRequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "api_endpoint")
    private String apiEndpoint;
    
    @Column(name = "request_method")
    private String requestMethod;
    
    @Column(name = "request_params")
    private String requestParams;
    
    @Column(name = "response_status")
    private Integer responseStatus;
    
    @Column(name = "response_body")
    private String responseBody;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    


}
