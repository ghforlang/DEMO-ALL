import com.edu.nbu.cn.demo.hongbao.HongBaoUtils;

import java.util.List;
import java.util.function.Function;

public class HongBaoUtilsTest {

    public static void main(String[] args) {
        List<Double> splitResult = HongBaoUtils.split(10);
        double sum = splitResult.stream().mapToDouble(value -> value).sum();
        System.out.println(sum + " " + splitResult);
    }

}
