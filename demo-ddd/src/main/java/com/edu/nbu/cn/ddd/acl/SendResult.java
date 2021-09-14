package com.edu.nbu.cn.ddd.acl;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
public class SendResult {
    private boolean success = false;

    public SendResult(boolean success) {
        this.success = success;
    }


    public static SendResult success(){
        return new SendResult(true);
    }
}
