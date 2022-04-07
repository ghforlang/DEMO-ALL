package com.edu.nbu.cn.data.cleanout.service;

import com.edu.nbu.cn.data.cleanout.constants.BizLabelTransfer;
import com.edu.nbu.cn.data.cleanout.mapper.CombinationMapper;
import com.edu.nbu.cn.data.cleanout.model.ehr.HealthIndicator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/7-6:41 PM
 * @since 1.0
 */
@Component
public class HealthIndicatorDataUpdateServiceImpl implements HealthIndicatorDataUpdateService{

    @Autowired
    private SqlSession session;
    private CombinationMapper combinationMapper;

    @Value("${data.cleanout.indicator.df.table}")
    private String indicatorTableName;

    @PostConstruct
    public void initBean(){
        combinationMapper = session.getMapper(CombinationMapper.class);
    }

    @Override
    public void generateBizLabelUpdateSql() {
        String generatedSqlFileName = "bizLabelsTransfer.sql";
        String sqlFilePath = Thread.currentThread().getContextClassLoader().getClass().getResource("/").getPath();;
        List<HealthIndicator> indicatorInfoList = combinationMapper.searchBizLabelsAll();
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
            bizLabelsMap.put(s, BizLabelTransfer.bitTransfer(Arrays.asList(StringUtils.split(s.substring(1,s.length() -1),","))));
        }

        //执行console生成的sql
        StringBuilder sb = new StringBuilder();
        bizLabelsMap.forEach((k,v) ->{
            sb.append("update " +  indicatorTableName + " set biz_labels_data = " + v + " where biz_labels = '" + k + "';\n" );
        });

        try {
            FileUtils.writeStringToFile(new File(sqlFilePath + generatedSqlFileName),sb.toString(),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
