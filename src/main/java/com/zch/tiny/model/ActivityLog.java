package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue
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
