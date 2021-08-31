import com.edu.nbu.cn.demo.hongbao.RandomHongBaoUtils;
import java.util.List;

public class TestHongbaoUtils {

    public static void main(String[] args) {
        testForMutilThread();
    }

    private static void testForMutilThread(){
        List<Long> hongbaoList = RandomHongBaoUtils.splitHongbao(10000L,10);
        long totalValue = hongbaoList.stream().mapToLong(value -> value).sum();
        System.out.println(Thread.currentThread().getName() + " - " + totalValue + " -> " + hongbaoList);
    }


}
