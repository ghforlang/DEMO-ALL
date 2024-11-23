package com.edu.nbu.cn.synctask.constants;

import lombok.Getter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/10-2:43 PM
 * @since 1.0
 */
@Getter
public enum ResourceTypeEnum {
    ONE("one","one"),TWO("two","two");


    private String resourceId;
    private String name;

    ResourceTypeEnum(String resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }
}
