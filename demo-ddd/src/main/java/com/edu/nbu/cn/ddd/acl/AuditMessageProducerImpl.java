package com.edu.nbu.cn.ddd.acl;


import com.edu.nbu.cn.ddd.entity.AuditMessage;

public class AuditMessageProducerImpl implements AuditMessageProducer{

    // TODO 通过springbean管理
    private KafakTemplate<String,String> kafakTemplate = new KafakTemplate<String,String>();
    private static final String TOPIC = "TEST";

    @Override
    public SendResult send(AuditMessage message) {
        kafakTemplate.send(TOPIC,message.serialize());
        return SendResult.success();
    }
}
