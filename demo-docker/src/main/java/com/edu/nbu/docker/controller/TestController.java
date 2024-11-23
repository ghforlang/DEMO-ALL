package com.edu.nbu.docker.controller;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2024/11/9-17:53
 * @since 1.0
 */

@RestController
@Slf4j
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    private HttpServletRequest httpRequest;

    private static final String RESULT_PREFIX = "code=";
    private static final String SUCCESS = "0000";
    private static final String FAIL= "1111";
    private static final String VG_CODE_RESULT_FIELD = "vgdecoderesult";
    private static final String DEVICE_NO_FIELD = "devicenumber";

    @PostMapping(value="/deviceCtl",consumes = MediaType.TEXT_HTML_VALUE,produces= MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String response(@RequestBody String params){
        if(StringUtils.isBlank(params)){
            System.out.println("参数不能为空!");
            return RESULT_PREFIX + FAIL;
        }

        //参数处理
        Map<String,String> paramMap = convertStringToMap(params);
        String codeContent = paramMap.get(VG_CODE_RESULT_FIELD);
        String deviceNo = paramMap.get(DEVICE_NO_FIELD);

        // TODO  业务逻辑处理
        if(StringUtils.isNotBlank(codeContent) && StringUtils.isNotBlank(deviceNo)){
            return RESULT_PREFIX + SUCCESS;
        }
        return RESULT_PREFIX + "1111";
    }

    private  Map<String, String> convertStringToMap(String input) {
        Map<String, String> map = new HashMap<>();
        String[] pairs = input.split("&&"); // 使用 "&&" 分割字符串
        for (String pair : pairs) {
            String[] keyValue = pair.split("="); // 使用 "=" 分割键值对
            if (keyValue.length == 2) {
                map.put(keyValue[0], keyValue[1]); // 将键值对放入Map中
            } else {
                // 处理异常情况，例如键值对格式不正确
                System.out.println("Invalid key-value pair: " + pair);
            }
        }
        return map;
    }
}
