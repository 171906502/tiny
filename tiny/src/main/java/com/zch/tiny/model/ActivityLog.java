package com.zch.tiny.model;

import jakarta.persistence.*;
import java.time.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "activity_type")
    private String activityType;
    
    @Column(name = "activity_details")
    private String activityDetails;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    


}
