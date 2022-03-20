import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu.nbu.cn.mybatis.application.Application;
import com.edu.nbu.cn.mybatis.mapper.BasicHealthInfoMapper;
import com.edu.nbu.cn.mybatis.mapper.EmployeesMapper;
import com.edu.nbu.cn.mybatis.model.Employees;
import com.edu.nbu.cn.mybatis.model.HealthIndicator;
import com.edu.nbu.cn.mybatis.model.ehr.BasicHealthInfo;
import com.edu.nbu.cn.mybatis.model.ehr.BloodFatInfo;
import com.edu.nbu.cn.mybatis.model.ehr.CodedValue;
import com.edu.nbu.cn.mybatis.model.ehr.ExcelModel;
import com.edu.nbu.cn.mybatis.model.ehr.FamilyHistory;
import com.edu.nbu.cn.mybatis.model.ehr.FamilyHistoryItem;
import com.edu.nbu.cn.mybatis.model.ehr.HealthIndicatorInfo;
import com.edu.nbu.cn.mybatis.model.ehr.HealthInfo;
import com.edu.nbu.cn.mybatis.model.ehr.MutexCombination;
import com.edu.nbu.cn.mybatis.model.ehr.RespiratoryRate;
import com.edu.nbu.cn.mybatis.utils.ExcelListener;
import com.edu.nbu.cn.mybatis.utils.ExcelUtils;
import com.edu.nbu.cn.mybatis.utils.SnowflakesIdGenerator;
import com.edu.nbu.cn.mybatis.utils.StreamUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMapper {

    @Resource
    private SqlSessionFactory sqlSessionFactory;
    // 数仓提供的指标源表表名
    private static String tableName = "health_record_healthindicator_df";

    private static final String excelPath = "/Users/fanwenhao/my-projects/DEMO-ALL/demo-mybatis-ext/src/main/resources/解密表的副本.xlsx";
    private static final String jsonPath = "/Users/fanwenhao/my-projects/DEMO-ALL/demo-mybatis-ext/src/main/resources/en_decrypt_json.json";
    private static final SnowflakesIdGenerator idGenerator = new SnowflakesIdGenerator(System.currentTimeMillis(),1023);

   @Test
    public void updateId(){
        //健康信息查询（）
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<BasicHealthInfo> healthInfoList = mapper.search();
        healthInfoList.forEach(healthInfo ->{
            healthInfo.setId(String.valueOf(idGenerator.next()));
            mapper.updateId(healthInfo);
        });

    }

//    @Test
    // 手机号更新
    @Deprecated
    public void testUpdatePhoneNo() throws IOException {
        List<ExcelModel> dataList = ExcelUtils.readModelFromJson(jsonPath);
        // phoneMap
        dataList = StreamUtils.listFilter(dataList,v -> StringUtils.isNotBlank(v.getPhoneNumber()) && StringUtils.isNotBlank(v.getPhoneNumberDe()));
        Map<String,String> phoneMap = StreamUtils.toMap(dataList,v -> v.getPhoneNumber(),v->v.getPhoneNumberDe());

        //健康信息查询（）
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<BasicHealthInfo> healthInfoList = mapper.search();

        // 数据更新,仅更新excel表中有值的；
        healthInfoList.forEach(healthInfo ->{
            if(StringUtils.isNotBlank(phoneMap.get(healthInfo.getPhoneNumber()))){
                healthInfo.setPhoneNumber(phoneMap.get(healthInfo.getPhoneNumber()));
            }
        });
        System.out.println(JSON.toJSONString(healthInfoList));
//
        healthInfoList.forEach(healthInfo -> {
            mapper.updatePhoneNumber(healthInfo);
        });
        System.out.println(JSON.toJSONString(mapper.search()));
    }

//    @Test
    // 身份证号解密转换
    @Deprecated
    public void testUpdateIdcardNo() throws IOException {
        List<ExcelModel> dataList = ExcelUtils.readModelFromJson(jsonPath);
        // idCardMap
        dataList = StreamUtils.listFilter(dataList,v -> StringUtils.isNotBlank(v.getIdCardNo()) && StringUtils.isNotBlank(v.getIdCardNoDe()));
        Map<String,String> idCardMap = StreamUtils.toMap(dataList,healthInfo-> healthInfo.getIdCardNo(),healthInfo->healthInfo.getIdCardNoDe());
        //健康信息查询（）
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<BasicHealthInfo> healthInfoList = mapper.search();

        // 数据更新
        healthInfoList.forEach(healthInfo ->{
            if(StringUtils.isNotBlank(idCardMap.get(healthInfo.getIdCardNo()))){
                healthInfo.setIdCardNo(idCardMap.get(healthInfo.getIdCardNo()));
            }
        });
        System.out.println(JSON.toJSONString(healthInfoList));

        healthInfoList.forEach(healthInfo -> {
            mapper.updateIdCardNo(healthInfo);
        });

        System.out.println(JSON.toJSONString(mapper.search()));
    }

    // 弥补数据错位问题
//    @Test

    @Deprecated
    public void healthPhoneNumberDataFix() throws IOException {
        List<ExcelModel> dataList = ExcelUtils.readModelFromJson(jsonPath);
        dataList = StreamUtils.listFilter(dataList,v -> StringUtils.isNotBlank(v.getPhoneNumberDe()) && StringUtils.isNotBlank(v.getIdCardNoDe()));
        Map<String,String> fixMap = StreamUtils.toMap(dataList,healthInfo-> healthInfo.getIdCardNoDe(),healthInfo->healthInfo.getPhoneNumberDe());

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<BasicHealthInfo> healthInfoList = mapper.search();
        List<BasicHealthInfo> tempList = new ArrayList<>();
        healthInfoList.forEach(healthInfo ->{

            if(StringUtils.isNotBlank(healthInfo.getPhoneNumber()) && healthInfo.getPhoneNumber().length() > 11){
                String realPhoneNumber = fixMap.get(healthInfo.getIdCardNo());
                healthInfo.setPhoneNumber(realPhoneNumber);
                tempList.add(healthInfo);
            }
        });

        tempList.forEach(healthInfo -> {
            if(StringUtils.isNotBlank(healthInfo.getPhoneNumber())){
                System.out.println(healthInfo.getPhoneNumber());
            }
            mapper.updatePhoneNumber(healthInfo);
        });
    }

    @Test
    public void testHealthInfo() throws IOException {
        int count = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<BasicHealthInfo> healthInfoList = mapper.search();
        System.out.println(healthInfoList);
    }

    @Test
    public void updateHealthInfoTable0(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<HealthInfo> healthInfoList = mapper.searchHealthInfo();
//        System.out.println(healthInfoList);
        healthInfoList.forEach(healthInfo ->{
            // abo_blood_type 字段处理 需要的时候放开
            if(StringUtils.isNotBlank(healthInfo.getAboBloodTypeId()) && StringUtils.isNotBlank(healthInfo.getAboBloodTypeName())){
                CodedValue codedValue = new CodedValue(healthInfo.getAboBloodTypeId(),healthInfo.getAboBloodTypeName());
                healthInfo.setAboBloodTypeName(JSON.toJSONString(codedValue));
                System.out.println(healthInfo.getAboBloodTypeName());
                mapper.updateExtraFields(healthInfo);
            }
             // rh_blood_type 字段处理 需要的时候放开
//            if(StringUtils.isNotBlank(healthInfo.getRhBloodTypeId()) && StringUtils.isNotBlank(healthInfo.getRhBloodTypeName())){
//                CodedValue codedValue = new CodedValue(healthInfo.getRhBloodTypeId(),healthInfo.getRhBloodTypeName());
//               healthInfo.setRhBloodTypeName(JSON.toJSONString(codedValue));
//                System.out.println(healthInfo.getRhBloodTypeName());
//                mapper.updateExtraFields(healthInfo);
//            }

            // martial_status 字段处理,需要的时候放开
//            if(StringUtils.isNotBlank(healthInfo.getMartialStatusId()) && StringUtils.isNotBlank(healthInfo.getMartialStatusName())){
//                CodedValue codedValue = new CodedValue(healthInfo.getMartialStatusId(),healthInfo.getMartialStatusName());
//               healthInfo.setMartialStatusName(JSON.toJSONString(codedValue));
//                System.out.println(healthInfo.getMartialStatusName());
//               mapper.updateExtraFields(healthInfo);
//            }

            //fertility_status_name 字段处理,需要的时候放开
//            if(StringUtils.isNotBlank(healthInfo.getFertilityStatusId()) && StringUtils.isNotBlank(healthInfo.getFertilityStatusName())){
//                CodedValue codedValue = new CodedValue(healthInfo.getFertilityStatusId(),healthInfo.getFertilityStatusName());
//               healthInfo.setFertilityStatusName(JSON.toJSONString(codedValue));
//                System.out.println(healthInfo.getFertilityStatusName());
//                mapper.updateExtraFields(healthInfo);
//            }

            // 家族史字段处理 需要的时候放开
//            if(StringUtils.isNotBlank(healthInfo.getFamilyDiseases()) && StringUtils.isNotBlank(healthInfo.getFamilyHistoryIsNormal())){
//                FamilyHistory familyHistory = new FamilyHistory();
//                if("0".equals(healthInfo.getFamilyHistoryIsNormal())){
//                    familyHistory.setIsNormal("F");
//                }
//                List<FamilyHistoryItem> items = JSONObject.parseArray(healthInfo.getFamilyDiseases(),FamilyHistoryItem.class);
//                familyHistory.setFamilyHistoryItems(items);
//               healthInfo.setFamilyDiseases(JSON.toJSONString(familyHistory));
//                System.out.println(healthInfo.getFamilyDiseases());
//            mapper.updateExtraFields(healthInfo);
//            }

            //饮食口味
//            if(StringUtils.isNotBlank(healthInfo.getDietTasteList()) && StringUtils.isNotBlank(healthInfo.getDietTasteIsNormal())){
//                MutexCombination mc = new MutexCombination();
//                if("0".equals(healthInfo.getDietTasteIsNormal())){
//                    mc.setIsNormal("F");
//                }
//                mc.setCodedValues(JSONObject.parseArray(healthInfo.getDietTasteList(),CodedValue.class));
//               healthInfo.setDietTasteList(JSON.toJSONString(mc));
//                System.out.println(healthInfo.getDietTasteList());
//
//                mapper.updateExtraFields(healthInfo);
//            }


        });
    }

    @Test
    public void updateHealthInfoTable4(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<HealthInfo> healthInfoList = mapper.searchHealthInfo();


        healthInfoList.forEach(healthInfo ->{

            // 呼吸频率
            if(StringUtils.isNotBlank(healthInfo.getRespiratoryRate())){
                RespiratoryRate rr = JSON.parseObject(healthInfo.getRespiratoryRate(),RespiratoryRate.class);
                if(Objects.nonNull(rr.getValue())){
                    healthInfo.setRespiratoryRate(String.valueOf(rr.getValue()));
                }
                System.out.println(healthInfo.getRespiratoryRate());
                mapper.updateExtraFields4(healthInfo);
            }
        });
    }


    @Test
    public void updateHealthInfoTable2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<HealthInfo> healthInfoList = mapper.searchHealthInfo();
        healthInfoList.forEach(healthInfo ->{

            // 运动频率
//            if(StringUtils.isNotBlank(healthInfo.getSportFrequencyId()) && StringUtils.isNotBlank(healthInfo.getSportFrequencyName())){
//                CodedValue codedValue = new CodedValue(healthInfo.getSportFrequencyId(),healthInfo.getSportFrequencyName());
//                healthInfo.setSportFrequencyName(JSON.toJSONString(codedValue));
//
//                System.out.println(healthInfo.getSportFrequencyName());
//                mapper.updateExtraFields2(healthInfo);
//            }

            // 睡眠状况频率
//            if(StringUtils.isNotBlank(healthInfo.getSleepingSituationName()) && StringUtils.isNotBlank(healthInfo.getSleepingSituationId())){
//                CodedValue codedValue = new CodedValue(healthInfo.getSleepingSituationId(),healthInfo.getSleepingSituationName());
//                healthInfo.setSleepingSituationName(JSON.toJSONString(codedValue));
//
//                System.out.println(healthInfo.getSleepingSituationName());
//                mapper.updateExtraFields2(healthInfo);
//            }

            // 既往病史
//            if(StringUtils.isNotBlank(healthInfo.getPastDiseases()) && StringUtils.isNotBlank(healthInfo.getPastIllnessIsNormal())){
//                MutexCombination mc = new MutexCombination();
//                if("0".equals(healthInfo.getPastIllnessIsNormal())){
//                    mc.setIsNormal("F");
//                }
//                mc.setCodedValues(JSONObject.parseArray(healthInfo.getPastDiseases(),CodedValue.class));
//
//                healthInfo.setPastDiseases(JSON.toJSONString(mc));
////                System.out.println(healthInfo.getPastDiseases());
//                mapper.updateExtraFields2(healthInfo);
//            }

            // 吸烟史
//            if(StringUtils.isNotBlank(healthInfo.getSmokingStatusId()) && StringUtils.isNotBlank(healthInfo.getSmokingStatusName())){
//                CodedValue codedValue = new CodedValue(healthInfo.getSmokingStatusId(),healthInfo.getSmokingStatusName());
//                healthInfo.setSmokingStatusName(JSON.toJSONString(codedValue));
//
//                System.out.println(healthInfo.getSmokingStatusName());
//                mapper.updateExtraFields2(healthInfo);
//            }

            // 饮酒史
//            if(StringUtils.isNotBlank(healthInfo.getDrinking_status_id()) && StringUtils.isNotBlank(healthInfo.getDrinking_status_name())){
//                CodedValue codedValue = new CodedValue(healthInfo.getDrinking_status_id(),healthInfo.getDrinking_status_name());
//                healthInfo.setDrinking_status_name(JSON.toJSONString(codedValue));
//
////                System.out.println(healthInfo.getDrinking_status_name());
//                mapper.updateExtraFields2(healthInfo);
//            }

            // 睡眠状况
//            if(StringUtils.isNotBlank(healthInfo.getSleeping_hours_id()) && StringUtils.isNotBlank(healthInfo.getSleeping_hours_code())){
//                CodedValue codedValue = new CodedValue(healthInfo.getSleeping_hours_id(),healthInfo.getSleeping_hours_code());
//                healthInfo.setSleeping_hours_code(JSON.toJSONString(codedValue));
//
////                System.out.println(healthInfo.getSleeping_hours_code());
//                mapper.updateExtraFields2(healthInfo);
//            }

//            // 地址处理
//            Address address = new Address();
//            if(StringUtils.isNotBlank(healthInfo.getProvince_id()) && StringUtils.isNotBlank(healthInfo.getProvince_name())){
//                CodedValue province = new CodedValue(healthInfo.getProvince_id(),healthInfo.getProvince_name());
//                address.setProvince(province);
//            }
//            if(StringUtils.isNotBlank(healthInfo.getCity_id()) && StringUtils.isNotBlank(healthInfo.getCity_name())){
//                CodedValue province = new CodedValue(healthInfo.getCity_id(),healthInfo.getCity_name());
//                address.setCity(province);
//            }
//            if(StringUtils.isNotBlank(healthInfo.getCounty_id()) && StringUtils.isNotBlank(healthInfo.getCounty_name())){
//                CodedValue province = new CodedValue(healthInfo.getCounty_id(),healthInfo.getCounty_name());
//                address.setCounty(province);
//            }
//            if(StringUtils.isNotBlank(healthInfo.getTownship_id()) && StringUtils.isNotBlank(healthInfo.getTownship_name())){
//                CodedValue province = new CodedValue(healthInfo.getTownship_id(),healthInfo.getTownship_name());
//                address.setTownship(province);
//            }
//            if(StringUtils.isNotBlank(healthInfo.getVillage_id()) && StringUtils.isNotBlank(healthInfo.getVillage_name())){
//                CodedValue province = new CodedValue(healthInfo.getVillage_id(),healthInfo.getVillage_name());
//                address.setVillage(province);
//            }
//            if (StringUtils.isNotBlank(healthInfo.getAddress())){
//                address.setAddress(healthInfo.getAddress());
//            }
////            System.out.println(JSON.toJSONString(address));
//            healthInfo.setAddress(JSON.toJSONString(address));
//            mapper.updateExtraFields2(healthInfo);
        });
    }


//    @Test
    public void testBloodFat(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<BloodFatInfo> bloodFatInfoList = mapper.listFat(null);
        System.out.println(bloodFatInfoList);
        List<String> bizIds = bloodFatInfoList.stream().map(bloodFat -> bloodFat.getBizId()).collect(Collectors.toList());
        BasicHealthInfoMapper mapper2 = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<HealthIndicatorInfo> indicatorInfoList = mapper2.list(bizIds);
        System.out.println(indicatorInfoList);
    }

    @Test
    public void testGenerateBizLabelsDataSql(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BasicHealthInfoMapper mapper = sqlSession.getMapper(BasicHealthInfoMapper.class);
        List<HealthIndicator> indicatorInfoList = mapper.searchBizLabelsAll();

        Set<String> bizLabelsSet = new HashSet<>();
        indicatorInfoList.forEach(indicatorInfo ->{
            if(StringUtils.isNotBlank(indicatorInfo.getBizLabels())  && indicatorInfo.getBizLabels().length() > 2 ){
                bizLabelsSet.add(indicatorInfo.getBizLabels());
            }else{
                indicatorInfo.setBizLabelsData(0L);
            }
        });

        Map<String,Long> bizLabelsMap = new HashMap<>();
        for (String s : bizLabelsSet) {
            bizLabelsMap.put(s,BizLabelTransfer.bitTransfer(Arrays.asList(StringUtils.split(s.substring(1,s.length() -1),","))));
        }

        //执行console生成的sql
        bizLabelsMap.forEach((k,v) ->{
            System.out.println("update " +  tableName + " set biz_labels_data = " + v + " where biz_labels = '" + k + "';" );
        });
    }


//    @Test
    public void testInterceptor(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class);
        Employees employees = buildModel();
        mapper.insert(employees);
        sqlSession.close();
    }


    private static Employees buildModel(){
        Employees employees = new Employees();
        employees.setBirthDate(new Date());
        employees.setFirstName("zhang");
        employees.setLastName("san");
        employees.setGender(1);
        employees.setHireDate(new Date());
        return employees;
    }


}
