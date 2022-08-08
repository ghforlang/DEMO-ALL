package cn.edu.nbu.vault.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/5-4:45 PM
 * @since 1.0
 */
@RequestMapping(value = "/v1/demo")
@RestController
public class ExampleController {

    @Autowired
    private VaultTemplate  vaultTemplate;

    @GetMapping("/value")
    public String value(){
        System.out.println(vaultTemplate.opsForToken().toString());
        VaultResponseSupport<Secrets> secrets = vaultTemplate.read("secret/secrets",Secrets.class);
        System.out.println(secrets.getData().getUsername());
        System.out.println(secrets.getData().getPassword());
        return "demo.value";
    }
}
