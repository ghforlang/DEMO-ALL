package com.edu.nbu.cn.synctask.constants.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author laoshi . hua
 * @version 1.0 2023/11/27-4:38 PM
 * @since 1.0
 */
@Getter
public enum AsyncPatternEnum {

    /**
     * 先保存数据库再异步消息处理
     */
    SAVE_ASYNC("SAVE_THEN_DEAL","先保存数据库再异步消息处理"),

    /**
     * 先同步处理失败再保存数据库
     */
    SYNC_SAVE("SYNC_DEAL_FAIL_THEN_SAVE","先同步处理失败再保存数据库"),

    /**
     * 先异步消息处理失败再保存数据库
     */
    ASYNC_SAVE("ASYNC_DEAL_FAIL_THEN_SAVE","先异步消息处理失败再保存数据库"),

    /**
     * 仅异步消息处理
     */
    ASYNC("ASYNC_ONLY","仅异步消息处理"),

    /**
     * 仅异步线程处理
     */
    THREAD("THREAD_ONLY","仅异步线程处理");

    private String pattern;
    /**
     * 描述
     */
    private final String desc;

    AsyncPatternEnum(String pattern,String desc) {
        this.pattern = pattern;
        this.desc = desc;
    }

    public static AsyncPatternEnum getByPattern(String pattern){
        if(StringUtils.isBlank(pattern)){
            return null;
        }

        for (AsyncPatternEnum patternEnum : AsyncPatternEnum.values()) {
            if(patternEnum.getPattern().equals(pattern)){
                return patternEnum;
            }
        }
        return null;
    }

}
