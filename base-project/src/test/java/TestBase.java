import com.alibaba.fastjson.JSON;

public class TestBase {

    public static void print(Object obj){
        System.out.println(JSON.toJSONString(obj));
    }
}
