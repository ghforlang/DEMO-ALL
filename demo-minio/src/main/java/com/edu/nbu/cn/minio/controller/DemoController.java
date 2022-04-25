package com.edu.nbu.cn.minio.controller;

import com.edu.nbu.cn.minio.properties.MinioProperties;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/25-2:46 PM
 * @since 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioProperties properties;

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file) throws Exception {
        String path = "demo-" + UUID.randomUUID().toString();
        minioClient.putObject(PutObjectArgs.builder()
                        .bucket(properties.getBucket())
                        .object(path)
                        .stream(file.getInputStream(),file.getSize(),-1)
                        .contentType(file.getContentType())
                        .build());
        return String.format("%s/%s/%s",properties.getEndPoint(),properties.getBucket(),path);
    }


    @DeleteMapping("/delete")
    public void delete(@RequestParam("path") String path) throws Exception{
        minioClient.removeObject(RemoveObjectArgs.builder()
                        .bucket(properties.getBucket())
                        .object(path)
                        .build());
        System.out.println("operate success");
    }
}
