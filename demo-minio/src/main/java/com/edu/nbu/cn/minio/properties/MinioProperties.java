package com.edu.nbu.cn.minio.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/25-2:48 PM
 * @since 1.0
 */
@ConfigurationProperties(prefix = "config.minio.client")
@Getter
@Setter
@Component
public class MinioProperties {

    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucket;
}
