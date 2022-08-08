package javaagent.agentmain;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-3:02 PM
 * @since 1.0
 */
public class Agent {
    public static void  agentmain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, UnmodifiableClassException {
        inst.addTransformer(new Transform(),true);
        inst.retransformClasses(Class.forName("javaagent.agentmain.People2"));
    }
}
