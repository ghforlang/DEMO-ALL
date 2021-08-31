package com.edu.nbu.cn;

import com.alibaba.fastjson.JSON;
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
 * @Date 2021/4/26 3:39 下午
 * @since 1.0
 */

@Getter
@Setter
@AllArgsConstructor
public class DemoD {
    private List<String> greOrgCodes;
    private Boolean greyEnable = false;

    static DemoD valueOf(String codes){
        if(StringUtils.isBlank(codes)){
            return null;
        }
        return new DemoD(Arrays.asList(StringUtils.split(codes,',')),true);
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
