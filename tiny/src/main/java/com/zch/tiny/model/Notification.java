package com.zch.tiny.model;

import jakarta.persistence.*;
import java.time.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "message")
    private String message;
    
    @Column(name = "is_read")
    private Boolean isRead;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    


}
