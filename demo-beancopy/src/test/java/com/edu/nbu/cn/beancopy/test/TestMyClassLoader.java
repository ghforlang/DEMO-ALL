import com.edu.nbu.cn.demo.classloader.MyClassLoader;
import com.edu.nbu.cn.demo.classloader.TestCl;

import java.util.concurrent.TimeUnit;

public class TestMyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        while (true){
            MyClassLoader myClassLoader = new MyClassLoader();
            Class<?> clazz = myClassLoader.loadClass("com.edu.nbu.cn.demo.classloader.TestCl");
            TestCl testCl = (TestCl) clazz.newInstance();
            testCl.testDemo();
            TimeUnit.SECONDS.sleep(1L);
        }
    }
}
