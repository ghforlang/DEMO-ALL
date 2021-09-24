package com.edu.nbu.cn;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @version 1.0
 * @Date 2021/4/20 11:25 上午
 * @since 1.0
 */
@Getter
@Setter
@AllArgsConstructor
public class DemoDTO {

    private DemoD storeGreyConfig;
    private DemoD orgGreyConfig;


    static DemoDTO valueOf(String storeCodes,String orgCodes){
        if(StringUtils.isBlank(storeCodes)){
            return null;
        }
        DemoD d1 = DemoD.of(Arrays.asList(StringUtils.split(storeCodes,',')),false);
        DemoD d2 = DemoD.of(Arrays.asList(StringUtils.split(orgCodes,',')),false);
        DemoDTO dto = new DemoDTO(d1,d2);
        return dto;
    }

    public static void main(String[] args) {
        DemoDTO demoDTO = valueOf("store1,store2","org1,org2");
        System.out.println(demoDTO);
        System.out.println(System.identityHashCode(demoDTO));
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}
