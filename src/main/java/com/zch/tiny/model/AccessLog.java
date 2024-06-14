package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "access_log")
public class AccessLog {

    @Id
    @GeneratedValue
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
