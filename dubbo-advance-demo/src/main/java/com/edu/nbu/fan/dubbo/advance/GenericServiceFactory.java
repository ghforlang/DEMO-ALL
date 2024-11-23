package com.edu.nbu.fan.dubbo.advance;

import com.edu.nbu.fan.dubbo.advance.config.DubboConfig;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author laoshi . hua
 * @version 1.0 2022/10/21-5:32 PM
 * @since 1.0
 * 关于泛化调用，参考https://www.cnblogs.com/Ti1077/p/9641020.html
 * https://blog.csdn.net/guomeiran130/article/details/114284074
 */
@UtilityClass
public class GenericServiceFactory {

    private static final Map<String, ReferenceConfig<GenericService>> REFERENCE_MAP =
            Collections.synchronizedMap(new LinkedHashMap<String, ReferenceConfig<GenericService>>(500, 1, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > 2000;
                }
            });

    public static GenericService fetchGenericService(DubboConfig config){
        if(StringUtils.isBlank(config.getInterfaceName()) || StringUtils.isBlank(config.getMethod())){
            throw new RuntimeException("参数不能为空!");
        }

        if(StringUtils.isBlank(config.getUrl()) && StringUtils.isBlank(config.getRegistry())){
            throw new RuntimeException("注册中心或URL不能同时为空!");
        }
        int defaultTimeOut = Objects.isNull(config.getTimeout()) ? 1000 : config.getTimeout();
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig();

        if(StringUtils.isNotBlank(config.getUrl())){
            referenceConfig.setUrl(config.getUrl());
        }else{
            RegistryConfig registryConfig = new RegistryConfig(config.getRegistry());
            registryConfig.setTimeout(defaultTimeOut);
            referenceConfig.setRegistry(registryConfig);
        }

        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setRetries(config.getRetries());
        consumerConfig.setTimeout(defaultTimeOut);
        referenceConfig.setConsumer(consumerConfig);

        ApplicationConfig applicationConfig = ConfigManager.getInstance().getApplication().
                orElse(new ApplicationConfig("dubbo-advance-demo"));
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setInterface(config.getInterfaceName());
        referenceConfig.setTag(config.getTag());
        referenceConfig.setRetries(config.getRetries());
        referenceConfig.setTimeout(defaultTimeOut);
        referenceConfig.setGeneric(true);
        referenceConfig.setVersion(config.getVersion());
        referenceConfig.setGroup(config.getGroup());

        GenericService genericService = getService(referenceConfig);
        return genericService;

    }

    private static GenericService getService(ReferenceConfig<GenericService> reference){
        String key = ReferenceConfigCache.DEFAULT_KEY_GENERATOR.generateKey(reference);
        ReferenceConfig<GenericService> exist = REFERENCE_MAP.get(key);
        if(Objects.nonNull(exist)
                && registryEquals(exist.getRegistries(), reference.getRegistries())
                && Objects.equals(exist.getUrl(), reference.getUrl())
                && Objects.equals(exist.getApplication(), reference.getApplication())
                && Objects.equals(exist.getTag(), reference.getTag())
                && Objects.equals(exist.getTimeout(), reference.getTimeout())
                && Objects.equals(exist.getRetries(), reference.getRetries())){
            return exist.get();
        }
        REFERENCE_MAP.put(key,reference);
        return reference.get();
    }

    private static boolean registryEquals(List<RegistryConfig> exists, List<RegistryConfig> now){
        if(CollectionUtils.isEmpty(exists)){
            return CollectionUtils.isEmpty(now);
        }

        if(CollectionUtils.isEmpty(now)){
            return CollectionUtils.isEmpty(exists);
        }

        if(exists.size() != now.size()){
            return false;
        }

        return exists.equals(now);
    }
}
