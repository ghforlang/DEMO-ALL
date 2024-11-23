package com.edu.nbu.cn.spring.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2023/2/6-6:03 PM
 * @since 1.0
 */
@ConfigurationProperties("my.redis.sentinel")
@Getter
@Setter
@Component("myCacheProperties")
public class MyCacheProperties {
    private Integer database;
    private String password;
    private String master;
    private Set<String> nodes;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWait;
    private Integer maxActive;
}
