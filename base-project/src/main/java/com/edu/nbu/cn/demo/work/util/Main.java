package com.edu.nbu.cn.demo.work.util;

/**
 * @author laoshi . hua
 * @version 1.0 2021/11/19-4:13 下午
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\\u672A\\u77E5\\u7684\\u7CFB\\u7EDF\\u9519\\u8BEF");
    }

    private static API_55005 buildApi55005(){
        API_55005 api55005 = new API_55005();
        api55005.setType(1);

//        HospInfo hospInfo = new HospInfo();
//        hospInfo.setExtHospCode("H23023000133");
//        hospInfo.setExtHospName("克东县宝泉镇中心卫生院");
//        api55005.setHospInfo(hospInfo);
//
//        OperatorInfo operatorInfo = new OperatorInfo();
//        operatorInfo.setOperatorNo("002");
//        operatorInfo.setOperatorName("杨婷");
//        operatorInfo.setBizCycleNo("1000033004");
//        api55005.setOperatorInfo(operatorInfo);
//
//        PatientInfo patientInfo = new PatientInfo();
//        patientInfo.setSsUniteAreaCode("231100");
//        patientInfo.setClinicSsUniteAreaCode("231100");
//        patientInfo.setIdCardType("02");
//        patientInfo.setIdCardNo("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjZXJ0bm8iOiIyMzA3MDgxOTk4MDcyMDA0MTAiLCJtZHRydF9jZXJ0X3R5cGUiOiIwMiIsImlzcyI6Imhzcy11c2VyIiwiZXhwIjoxNjMxMjQzMTczLCJwc25fbmFtZSI6IueOi-W7uiJ9.te5G6ohN2Abrlu9pWGSQNFXuCFvcXOf1yUm0-GBCr3I");
//        patientInfo.setPatientName("张三");
//        api55005.setPatientInfo(patientInfo);
//        SettleItem item = new SettleItem();
//        item.setMiPrescriptionId("1");
//        item.setMiVisitId("1000181255");
//        item.setPersonalNo("230000000000000026482935");
//        item.setCommodityName();
//        api55005.setSettleItemList();
        return api55005;
    }
}
