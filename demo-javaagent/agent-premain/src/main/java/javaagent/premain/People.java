package javaagent.premain;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-2:03 PM
 * @since 1.0
 */

/**
 * 运行配置：新增JVM参数 -javaagent:/Users/fanwenhao/my-projects/DEMO-ALL/demo-javaagent/agent-premain/target/agent-premain-1.0-SNAPSHOT.jar
 * <archive>
 *     <manifestEntries>
 *     <Premain-class>javaagent.premain.Premain</Premain-class>
 *     <Can-Redefine-Classes>true</Can-Redefine-Classes>
 *     <Can-Retransform-Classes>true</Can-Retransform-Classes>
 *     </manifestEntries>
 * </archive>
 */
public class People {
    public static void main(String[] args) {
        System.out.println(new SayHello().sayHello());
    }
}
