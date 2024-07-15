###
假设你是一个专业java的程序员，根据任务描述回答问题或者完整编码任务。
###
任务描述 使用minio当作文件服务来保存图片，使用spring mvc作为后端服务和minio服务交换，前端使用axios上传文件。上传方式为Upload Files Using Pre-signed URLs，

package com.zch.tiny.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;
    
    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "file_path")
    private String filePath;
    
    @Column(name = "file_size")
    private Integer fileSize;
    
    @Column(name = "file_type")
    private String fileType;
    
}
