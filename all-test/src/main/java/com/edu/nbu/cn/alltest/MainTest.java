package com.edu.nbu.cn.alltest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wedoctor.cloud.open.api.RequestClient;
import com.wedoctor.cloud.open.api.bean.tradeCyclepayTob.req.Req;
import com.wedoctor.cloud.open.api.bean.tradeCyclepayTob.req.TradeCyclepayTobReq;
import com.wedoctor.cloud.open.api.bean.tradeCyclepayTob.resp.TradeCyclepayTobRes;

import java.util.Map;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/23-3:26 PM
 * @since 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        test2();
    }

    private static void test2(){
        RequestClient client = new RequestClient("my26YCLN7DJC3h23", "j8563Z62E5q8poL8w7A26V0n85H1GP03", "13JZGx91X");
//        client.setReqUrl("http://openapi.guahao.com/openapi");
        client.setReqUrl("http://pre-openapi.guahao.com/openapi");
        TradeCyclepayTobReq req = new TradeCyclepayTobReq();
        Req subReq = new Req();
        subReq.setOriginAmount(1L);
        subReq.setDealAmount(1L);
        subReq.setAgreementNo("2172549257459566844");
        subReq.setBizOrderNo("yzk2b00320241026112933962506");
        subReq.setBuyerId("9999");
        subReq.setBuyerName("三方合作");
        subReq.setDescription("周期扣款订单测试");
        subReq.setTitle("周期扣款订单测试");
        subReq.setPartnerIdentifier("coop_feier");
        subReq.setNotifyUrl("https://backnotify.kms9.cn/myyzk/payback");
        req.setReq(subReq);
        TradeCyclepayTobRes res = client.execute(req, new TypeReference<TradeCyclepayTobRes>() {});
        System.out.println(JSON.toJSONString(res));
    }

    private static void test1(){
        String filePath = "META-INF/test.properties";
        Map<String,String> resultMap = PropertiesUtils.loadFromProperties(filePath);
        resultMap.forEach((k,v) -> System.out.println(k + " : " + v));

        Class<?> clazz = StackTraceUtils.getMainClass();
        System.out.println(clazz.getName());
    }
}
