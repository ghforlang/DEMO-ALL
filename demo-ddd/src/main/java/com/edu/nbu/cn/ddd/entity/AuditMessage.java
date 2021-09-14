package com.edu.nbu.cn.ddd.entity;


import com.edu.nbu.cn.ddd.dp.Money;
import com.edu.nbu.cn.ddd.dp.UserId;
import lombok.Value;

import javax.sound.sampled.AudioInputStream;
import java.util.Date;

@Value
public class AuditMessage {
    private Account from;
    private Account to;
    private UserId userId;
    private Money money;
    private Date date;

    public String serialize(){
        return userId + "," + from + "," + to + "," + money + "," + date;
    }

    public AuditMessage disSerialize(String value){
        // TODO
        return null;
    }
}
