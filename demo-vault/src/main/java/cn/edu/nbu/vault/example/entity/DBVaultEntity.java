package cn.edu.nbu.vault.example.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/8-2:04 PM
 * @since 1.0
 */
@Getter
@Setter
public class DBVaultEntity implements VaultEntity{
    private String username;
    private String password;

    public DBVaultEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static DBVaultEntity valueOf(String username,String password){
        return new DBVaultEntity(username,password);
    }
}
