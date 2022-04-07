package com.edu.nbu.cn.data.cleanout.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu.nbu.cn.data.cleanout.mapper.CombinationMapper;
import com.edu.nbu.cn.data.cleanout.model.ehr.Address;
import com.edu.nbu.cn.data.cleanout.model.ehr.BasicHealthInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.CodedValue;
import com.edu.nbu.cn.data.cleanout.model.ehr.FamilyHistory;
import com.edu.nbu.cn.data.cleanout.model.ehr.FamilyHistoryItem;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthInfo;
import com.edu.nbu.cn.data.cleanout.model.ehr.MutexCombination;
import com.edu.nbu.cn.data.cleanout.model.ehr.RespiratoryRate;
import com.edu.nbu.cn.data.cleanout.utils.SnowflakesIdGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-3:40 PM
 * @since 1.0
 */
@Component("basicHealthInfoDataUpdateService")
public class BasicHealthInfoDataUpdateServiceImpl implements BasicHealthInfoDataUpdateService {


    private static final SnowflakesIdGenerator idGenerator = new SnowflakesIdGenerator(System.currentTimeMillis(),1023);

    @Autowired
    private SqlSession session;
    private CombinationMapper combinationMapper;

    @PostConstruct
    public void initBean(){
        combinationMapper = session.getMapper(CombinationMapper.class);
    }


    @Override
    public void updateBasicHealthInfoId(BasicHealthInfo basicHealthInfo) {
        basicHealthInfo.setId(String.valueOf(idGenerator.next()));
        combinationMapper.updateId(basicHealthInfo);
    }

    @Override
    public List<BasicHealthInfo> searchAllBasicHealthInfo() {
        return combinationMapper.searchSimpleHealthInfo();
    }

    @Override
    public List<HealthInfo> searchAllHealthInfo() {
        return combinationMapper.searchHealthInfo();
    }

    @Override
    public void updateExtraFields0(List<HealthInfo> healthInfoList) {
        if(CollectionUtils.isEmpty(healthInfoList)){
            return;
        }
        String healthInfoTable0ExtraFieldFile = "basicHealthinfoExtraField_0.json";
        String path = Thread.currentThread().getContextClassLoader().getClass().getResource("/").getPath();

        Set<String> peopleIds = new HashSet<>();
        for (HealthInfo healthInfo : healthInfoList){
            boolean needUpdate = false;
            // abo_blood_type 字段处理 需要的时候放开
            if(StringUtils.isNotBlank(healthInfo.getAboBloodTypeId()) && StringUtils.isNotBlank(healthInfo.getAboBloodTypeName())){
                CodedValue codedValue = new CodedValue(healthInfo.getAboBloodTypeId(),healthInfo.getAboBloodTypeName());
                healthInfo.setAboBloodTypeName(JSON.toJSONString(codedValue));
                needUpdate = true;

            }
            // rh_blood_type 字段处理 需要的时候放开
            if(StringUtils.isNotBlank(healthInfo.getRhBloodTypeId()) && StringUtils.isNotBlank(healthInfo.getRhBloodTypeName())){
                CodedValue codedValue = new CodedValue(healthInfo.getRhBloodTypeId(),healthInfo.getRhBloodTypeName());
                healthInfo.setRhBloodTypeName(JSON.toJSONString(codedValue));
                needUpdate = true;
            }

            // martial_status 字段处理,需要的时候放开
            if(StringUtils.isNotBlank(healthInfo.getMartialStatusId()) && StringUtils.isNotBlank(healthInfo.getMartialStatusName())){
                CodedValue codedValue = new CodedValue(healthInfo.getMartialStatusId(),healthInfo.getMartialStatusName());
                healthInfo.setMartialStatusName(JSON.toJSONString(codedValue));
                needUpdate  = true;
            }

            //fertility_status_name 字段处理,需要的时候放开
            if(StringUtils.isNotBlank(healthInfo.getFertilityStatusId()) && StringUtils.isNotBlank(healthInfo.getFertilityStatusName())){
                CodedValue codedValue = new CodedValue(healthInfo.getFertilityStatusId(),healthInfo.getFertilityStatusName());
                healthInfo.setFertilityStatusName(JSON.toJSONString(codedValue));
                needUpdate = true;
            }

            // 家族史字段处理 需要的时候放开
            if(StringUtils.isNotBlank(healthInfo.getFamilyDiseases()) && StringUtils.isNotBlank(healthInfo.getFamilyHistoryIsNormal())){
                FamilyHistory familyHistory = new FamilyHistory();
                if("0".equals(healthInfo.getFamilyHistoryIsNormal())){
                    familyHistory.setIsNormal("F");
                }
                List<FamilyHistoryItem> items = JSONObject.parseArray(healthInfo.getFamilyDiseases(),FamilyHistoryItem.class);
                familyHistory.setFamilyHistoryItems(items);
                healthInfo.setFamilyDiseases(JSON.toJSONString(familyHistory));
                needUpdate = true;
            }

            //饮食口味
            if(StringUtils.isNotBlank(healthInfo.getDietTasteList()) && StringUtils.isNotBlank(healthInfo.getDietTasteIsNormal())){
                MutexCombination mc = new MutexCombination();
                if("0".equals(healthInfo.getDietTasteIsNormal())){
                    mc.setIsNormal("F");
                }
                System.out.println(healthInfo.getDietTasteList());
                mc.setCodedValues(JSONObject.parseArray(healthInfo.getDietTasteList(),CodedValue.class));
                healthInfo.setDietTasteList(JSON.toJSONString(mc));
                needUpdate = true;
            }

            if(needUpdate){
                System.out.println("pepoleId:[" + healthInfo.getPeopleId() + "],needUpdate:[" + needUpdate + "]" );
                combinationMapper.updateExtraFields(healthInfo);
                peopleIds.add(healthInfo.getPeopleId());
            }
        }

        // 验证，并写入文件
        if(CollectionUtils.isNotEmpty(peopleIds)){
            List<HealthInfo> afterUpdateResult = combinationMapper.listExtraFieldByPeopleIds(peopleIds);
            try {
                FileUtils.writeStringToFile(new File(path + healthInfoTable0ExtraFieldFile),JSON.toJSONString(afterUpdateResult),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateExtraFields2(List<HealthInfo> healthInfoList) {
        if(CollectionUtils.isEmpty(healthInfoList)){
            return;
        }
        String healthInfoTable2ExtraFieldFile = "basicHealthinfoExtraField_2.json";
        String path = Thread.currentThread().getContextClassLoader().getClass().getResource("/").getPath();

        Set<String> peopleIds = new HashSet<>();
        for(HealthInfo healthInfo : healthInfoList){
            boolean needUpdate = false;
            // 运动频率
            if(StringUtils.isNotBlank(healthInfo.getSportFrequencyId()) && StringUtils.isNotBlank(healthInfo.getSportFrequencyName())){
                CodedValue codedValue = new CodedValue(healthInfo.getSportFrequencyId(),healthInfo.getSportFrequencyName());
                healthInfo.setSportFrequencyName(JSON.toJSONString(codedValue));
                needUpdate = true;
                System.out.println(healthInfo.getSportFrequencyName());
            }

            // 睡眠状况频率
            if(StringUtils.isNotBlank(healthInfo.getSleepingSituationName()) && StringUtils.isNotBlank(healthInfo.getSleepingSituationId())){
                CodedValue codedValue = new CodedValue(healthInfo.getSleepingSituationId(),healthInfo.getSleepingSituationName());
                healthInfo.setSleepingSituationName(JSON.toJSONString(codedValue));
                needUpdate = true;
                System.out.println(healthInfo.getSleepingSituationName());
            }

            // 既往病史
            if(StringUtils.isNotBlank(healthInfo.getPastDiseases()) && StringUtils.isNotBlank(healthInfo.getPastIllnessIsNormal())){
                MutexCombination mc = new MutexCombination();
                if("0".equals(healthInfo.getPastIllnessIsNormal())){
                    mc.setIsNormal("F");
                }
                mc.setCodedValues(JSONObject.parseArray(healthInfo.getPastDiseases(),CodedValue.class));
                needUpdate = true;
                healthInfo.setPastDiseases(JSON.toJSONString(mc));
            }

            // 吸烟史
            if(StringUtils.isNotBlank(healthInfo.getSmokingStatusId()) && StringUtils.isNotBlank(healthInfo.getSmokingStatusName())){
                CodedValue codedValue = new CodedValue(healthInfo.getSmokingStatusId(),healthInfo.getSmokingStatusName());
                healthInfo.setSmokingStatusName(JSON.toJSONString(codedValue));
                needUpdate = true;
                System.out.println(healthInfo.getSmokingStatusName());
            }

            // 饮酒史
            if(StringUtils.isNotBlank(healthInfo.getDrinking_status_id()) && StringUtils.isNotBlank(healthInfo.getDrinking_status_name())){
                CodedValue codedValue = new CodedValue(healthInfo.getDrinking_status_id(),healthInfo.getDrinking_status_name());
                healthInfo.setDrinking_status_name(JSON.toJSONString(codedValue));
                needUpdate = true;
                System.out.println(healthInfo.getDrinking_status_name());
            }

            // 睡眠状况
            if(StringUtils.isNotBlank(healthInfo.getSleeping_hours_id()) && StringUtils.isNotBlank(healthInfo.getSleeping_hours_code())){
                CodedValue codedValue = new CodedValue(healthInfo.getSleeping_hours_id(),healthInfo.getSleeping_hours_code());
                healthInfo.setSleeping_hours_code(JSON.toJSONString(codedValue));
                needUpdate = true;
                System.out.println(healthInfo.getSleeping_hours_code());
            }

            // 地址处理
            Address address = null;
            if(StringUtils.isNotBlank(healthInfo.getProvince_id()) && StringUtils.isNotBlank(healthInfo.getProvince_name())){
                address = Objects.isNull(address) ? new Address() : address;
                CodedValue province = new CodedValue(healthInfo.getProvince_id(),healthInfo.getProvince_name());
                address.setProvince(province);
            }
            if(StringUtils.isNotBlank(healthInfo.getCity_id()) && StringUtils.isNotBlank(healthInfo.getCity_name())){
                address = Objects.isNull(address) ? new Address() : address;
                CodedValue province = new CodedValue(healthInfo.getCity_id(),healthInfo.getCity_name());
                address.setCity(province);
            }
            if(StringUtils.isNotBlank(healthInfo.getCounty_id()) && StringUtils.isNotBlank(healthInfo.getCounty_name())){
                address = Objects.isNull(address) ? new Address() : address;
                CodedValue province = new CodedValue(healthInfo.getCounty_id(),healthInfo.getCounty_name());
                address.setCounty(province);
            }
            if(StringUtils.isNotBlank(healthInfo.getTownship_id()) && StringUtils.isNotBlank(healthInfo.getTownship_name())){
                address = Objects.isNull(address) ? new Address() : address;
                CodedValue province = new CodedValue(healthInfo.getTownship_id(),healthInfo.getTownship_name());
                address.setTownship(province);
            }
            if(StringUtils.isNotBlank(healthInfo.getVillage_id()) && StringUtils.isNotBlank(healthInfo.getVillage_name())){
                address = Objects.isNull(address) ? new Address() : address;
                CodedValue province = new CodedValue(healthInfo.getVillage_id(),healthInfo.getVillage_name());
                address.setVillage(province);
            }
            if (StringUtils.isNotBlank(healthInfo.getAddress())){
                address = Objects.isNull(address) ? new Address() : address;
                address.setAddress(healthInfo.getAddress());
            }

            if(Objects.nonNull(address)){
                needUpdate = true;
                healthInfo.setAddress(JSON.toJSONString(address));
                System.out.println(JSON.toJSONString(address));
            }

            if(needUpdate){
                System.out.println("pepoleId:[" + healthInfo.getPeopleId() + "],needUpdate:[" + needUpdate + "]" );
                combinationMapper.updateExtraFields2(healthInfo);
                peopleIds.add(healthInfo.getPeopleId());
            }
        }

        // 验证，并写入文件
        if(CollectionUtils.isNotEmpty(peopleIds)){
            List<HealthInfo> afterUpdateResult = combinationMapper.listExtraField2ByPeopleIds(peopleIds);
            try {
                FileUtils.writeStringToFile(new File(path + healthInfoTable2ExtraFieldFile),JSON.toJSONString(afterUpdateResult),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateExtraFields4(List<HealthInfo> healthInfoList) {
        if(CollectionUtils.isEmpty(healthInfoList)){
            return;
        }
        String healthInfoTable4ExtraFieldFile = "basicHealthinfoExtraField_4.json";
        String path = Thread.currentThread().getContextClassLoader().getClass().getResource("/").getPath();

        Set<String> peopleIds = new HashSet<>();
        for(HealthInfo healthInfo : healthInfoList){
            if(StringUtils.isNotBlank(healthInfo.getRespiratoryRate())){
                RespiratoryRate rr = JSON.parseObject(healthInfo.getRespiratoryRate(),RespiratoryRate.class);
                if(Objects.nonNull(rr.getValue())){
                    healthInfo.setRespiratoryRate(String.valueOf(rr.getValue()));
                }
                peopleIds.add(healthInfo.getPeopleId());
                combinationMapper.updateExtraFields4(healthInfo);
            }
        }

        // 验证，并写入文件
        if(CollectionUtils.isNotEmpty(peopleIds)){
            List<HealthInfo> afterUpdateResult = combinationMapper.listExtraField4ByPeopleIds(peopleIds);
            try {
                FileUtils.writeStringToFile(new File(path + healthInfoTable4ExtraFieldFile),JSON.toJSONString(afterUpdateResult),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
