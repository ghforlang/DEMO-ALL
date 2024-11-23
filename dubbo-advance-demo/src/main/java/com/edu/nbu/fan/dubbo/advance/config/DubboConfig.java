package com.edu.nbu.fan.dubbo.advance.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/10/21-5:30 PM
 * @since 1.0
 */
@Getter
@Setter
public class DubboConfig {
    private String registry;
    private String appName;
    private String url;
    private String tag;
    private String interfaceName;
    private String version;
    private String group;
    private Integer retries;
    private Integer timeout;

    private String method;
    private List<Args> args;
    private List<Attachment> attachments;

    @Getter
    @Setter
    public static class Args {
        private String type;
        private String value;
    }

    @Getter
    @Setter
    public static class Attachment {
        private String name;
        private String value;
    }

    @Getter
    @Setter
    public static class DubboMethodArgs{
       private String method;
       private List<String> argTypes;
       private List<Object> argValues;

        public void addType(String type) {
            if (CollectionUtils.isEmpty(argTypes)) {
                argTypes = new ArrayList<>();
            }
            argTypes.add(type);
        }

        public void addValue(Object value) {
            if (CollectionUtils.isEmpty(argValues)) {
                argValues = new ArrayList<>();
            }
            argValues.add(value);
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }
}
