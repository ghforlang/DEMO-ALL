package javaagent.agentmain;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-5:21 PM
 * @since 1.0
 */
public class People2 {
    public void sayHello(String name){
        System.out.println(String.format("%s say hello!",name));
    }

    public static void main(String[] args) throws InterruptedException {
        People2 p = new People2();
        for(;;){
            Thread.sleep(1000);
            p.sayHello(Thread.currentThread().getName());
        }
    }
}
