package com.edu.nbu.cn.minio.config;

import com.edu.nbu.cn.minio.properties.MinioProperties;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/25-2:44 PM
 * @since 1.0
 */
@Configuration
public class MinioConfiguration {

    @Autowired
    private MinioProperties properties;

    @Bean
    MinioClient minioClient(){
        return MinioClient.builder()
                .endpoint(properties.getEndPoint())
                .credentials(properties.getAccessKey(),properties.getSecretKey())
                .build();
    }
}
