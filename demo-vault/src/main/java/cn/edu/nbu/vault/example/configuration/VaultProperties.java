package cn.edu.nbu.vault.example.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/8-1:59 PM
 * @since 1.0
 */

@ConfigurationProperties("cn.edu.nbu.vault")
@Getter
@Setter
public class VaultProperties {
    private String token;
    private String host;
    private Integer port;
}
