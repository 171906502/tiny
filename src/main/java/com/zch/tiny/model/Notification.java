package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue
    private Integer notificationId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "message")
    private String message;
    
    @Column(name = "is_read")
    private String isRead;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    


}
