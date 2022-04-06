package com.edu.nbu.cn.data.cleanout.model.ehr;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/13-5:45 下午
 * @since 1.0
 */
public class HealthIndicatorInfo {
    private String id;
    private String bizId;
    private String peopleId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }
}
