package com.edu.nbu.docker.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.edu.nbu.docker.service.BasicHealthInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author laoshi . hua
 * @version 1.0 2024/7/10-18:56
 * @since 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/docker")
public class DeviceController {

    @Autowired
    private BasicHealthInfoService basicHealthInfoService;

    static{
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = loggerContext.getLoggerList();
        loggerList.forEach(logger -> logger.setLevel(Level.INFO));
    }

    @GetMapping(value="/testCE")
    @ResponseBody
    public String hello(@RequestParam String id){
//        BasicHealthInfoPO basicHealthInfo = basicHealthInfoService.getBasicHealthInfo(Long.valueOf(id));
//        String requestUUID = UUID.randomUUID().toString();
//        return  "request uuid : " + requestUUID + "\n" + JSON.toJSONString(basicHealthInfo);

        for(int i=0;i<100;i++){
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            log.info("testCE-" + i + "-" + (endTime-startTime) + "ms");
        }
        return "success";
    }

    @GetMapping(value="/testCT")
    @ResponseBody
    public String testCT(@RequestParam("ip") String ip,@RequestParam("num") Integer num) throws IOException {
        final ExecutorService executor = Executors.newFixedThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        String req = "[\n" +
                "    123,\n" +
                "    234\n" +
                "]";
        for(int i=0;i<num;i++){
            executor.submit(() ->{
                        long startTime = System.currentTimeMillis();
                        try {
                            Request.Post("http://" + ip+ "/trade/inv/querySkuInventoryFromDB")
                                    .addHeader("'Content-Type'","application/json")
                                    .bodyString(req, ContentType.APPLICATION_JSON)
                                    .execute()
                                    .returnResponse();
                        } catch (IOException e) {
                            log.error("请求异常,异常message:{}",e.getMessage());
                        }
                        long endTime = System.currentTimeMillis();
                        if(endTime-startTime > 50){
                            atomicInteger.getAndIncrement();
                            log.info("testCT-" + ip + "-" + (endTime-startTime) + "ms");
                        }
                    });
        }
        log.info("costTime > 50ms,count = " + atomicInteger);
        executor.shutdown();
        return "success";
    }

}
