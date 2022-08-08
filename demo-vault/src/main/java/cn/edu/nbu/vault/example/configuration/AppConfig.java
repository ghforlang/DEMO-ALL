package cn.edu.nbu.vault.example.configuration;

import cn.edu.nbu.vault.example.Secrets;
import javafx.scene.transform.Scale;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultTemplate;

import java.net.URI;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/5-5:05 PM
 * @since 1.0
 */
@PropertySource("configuration.properties")
@Configuration
@EnableConfigurationProperties(VaultProperties.class)
public class AppConfig extends AbstractVaultConfiguration {

    @Autowired
    private VaultProperties vaultProperties;

    @SneakyThrows
    @Override
    public VaultEndpoint vaultEndpoint() {
        URI uri = new URI("https://127.0.0.1:8200");
        VaultEndpoint vaultEndpoint = VaultEndpoint.from(uri);
        return vaultEndpoint;
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(vaultProperties.getToken());
    }

    @Bean
    public VaultTemplate vaultTemplate(){
        return new VaultTemplate(vaultEndpoint(),clientAuthentication());
    }

}
