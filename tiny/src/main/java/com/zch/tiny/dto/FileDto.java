package com.zch.tiny.dto;

import lombok.Data;
import java.time.*;

@Data
public class FileDto {

    private Integer fileId;    
    private String fileName;    
    private String filePath;    
    private Integer fileSize;    
    private String fileType;    
    private Integer uploadedBy;    
    private LocalDateTime uploadedAt;    
    private String status;    

}
