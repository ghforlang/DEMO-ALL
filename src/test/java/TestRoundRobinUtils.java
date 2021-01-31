import com.edu.nbu.cn.demo.loadbalance.RoundRobinUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestRoundRobinUtils {


    public static final Map<String,Integer> MAPS = new ConcurrentHashMap<>(8);

    static{
        MAPS.put("A",5);
        MAPS.put("B",1);
        MAPS.put("C",1);
    }

    public static void main(String[] args) {
        List<String> resultList = RoundRobinUtils.smoothRoundRobin(MAPS,7);
        System.out.println(StringUtils.join(resultList));
    }
}
