package com.zch.tiny.controller;

import com.zch.tiny.dto.FileDto;
import com.zch.tiny.model.File;
import com.zch.tiny.service.FileService;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import io.minio.messages.Item;

import com.zch.tiny.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService service;

    private final FileMapper mapper = FileMapper.INSTANCE;

     @Autowired
    private MinioClient minioClient;

    @GetMapping("/generate-presigned-url")
    public String generatePreSignedUrl(@RequestParam String bucketName, @RequestParam String objectName) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.PUT)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(1, TimeUnit.HOURS)
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/list-objects")
    public List<String> listObjects(@RequestParam String bucketName) throws Exception{
        List<String> urls = new ArrayList<>();
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket(bucketName).maxKeys(10).build());

            for (Result<Item> result : results) {
                Item item = result.get();
                String viewUrl = minioClient.getPresignedObjectUrl(
                        GetPresignedObjectUrlArgs.builder()
                                .method(Method.GET)
                                .bucket(bucketName)
                                .object(item.objectName())
                                .expiry(1, TimeUnit.HOURS)
                                .build());
                urls.add(viewUrl);
            }
        } catch (MinioException e) {
            e.printStackTrace();
        }
        return urls;
    }

    @GetMapping
    public List<FileDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<FileDto> findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PostMapping
    public FileDto save(@RequestBody FileDto dto) {
        File entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/search")
    public List<FileDto> findByExample(@RequestBody FileDto dto) {
        File example = mapper.toEntity(dto);
        return service.findByExample(example).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
