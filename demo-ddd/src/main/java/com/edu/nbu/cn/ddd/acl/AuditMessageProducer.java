package com.edu.nbu.cn.ddd.acl;


import com.edu.nbu.cn.ddd.entity.AuditMessage;

public interface AuditMessageProducer {

    SendResult send(AuditMessage message);
}
