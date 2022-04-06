import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/11-5:41 下午
 * @since 1.0
 */
public class BizLabelTransfer {

    public static Long bitTransfer(List<String> bizLabels){
        if(CollectionUtils.isEmpty(bizLabels)){
            return 0L;
        }
        System.out.println("before transfer : " + JSON.toJSONString(bizLabels));
        Map<String,HealthDataBizLabelEnum> nameLabelMap = HealthDataBizLabelEnum.NAME_MAP;
        Map<String,HealthIndicatorEnum> nameBitMap = HealthIndicatorEnum.CONTAINED_INDICATORS;
        Map<String,Integer> resultMap = new HashMap<>();
        nameLabelMap.forEach((k,v) ->{
            nameBitMap.forEach((k1,v1) ->{
                if(v.getName().equals(v1.getIndicatorName())){
                    resultMap.putIfAbsent(v.getLabel(),v1.getBit());
                }
            });
        });

        List<Integer> resultList = bizLabels.stream().map(v -> resultMap.get(v.trim())).collect(Collectors.toList());
        Long result = bitToLong(resultList);
        System.out.println("after transfer : " +  JSON.toJSONString(resultList) + ":" + result);
        System.out.println("______________________________________________________________________________");
        return result;
    }


    private static Long bitToLong(List<Integer> bizLabels) {
        if (CollectionUtils.isEmpty(bizLabels)) {
            return 0L;
        }
        Long labels = 0L;
        for (Integer bit : bizLabels) {
            if(bit <= 0){
                continue;
            }
            labels = labels + (1 << bit-1);
        }
        return labels;
    }

    public static void main(String[] args) {
        bitTransfer(Arrays.asList("bp","bs","wa"));
    }
}
