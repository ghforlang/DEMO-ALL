package cn.edu.nbu.vault.example;

import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import java.util.UUID;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/5-4:22 PM
 * @since 1.0
 */
public class Main {
    private static final String uuid = UUID.randomUUID().toString();

    public static void main(String[] args) {
        VaultEndpoint vaultEndpoint = new VaultEndpoint();
        vaultEndpoint.setScheme("http");
        VaultTemplate vt = new VaultTemplate(vaultEndpoint,new TokenAuthentication("hvs.It67NLRLLsi1xTXRZlmIQzS2"));
        VaultResponseSupport<Secrets> response = vt.read("secret/data/db",Secrets.class);
        System.out.println(response.getData().getUsername());
        System.out.println(response.getData().getPassword());
//        vt.delete("secret/secrets");
    }
}
