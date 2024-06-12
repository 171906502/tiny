package com.zch.tiny.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue
    private Integer fileId;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "file_size")
    private Integer fileSize;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "uploaded_by")
    private Integer uploadedBy;
    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
    @Column(name = "status")
    private String status;


}
