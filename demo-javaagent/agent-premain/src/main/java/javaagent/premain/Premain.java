package javaagent.premain;

import java.lang.instrument.Instrumentation;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-2:21 PM
 * @since 1.0
 */
public class Premain {
    public static void premain(String agentArgs, Instrumentation inst){
        System.out.println("this is agent running!");
        inst.addTransformer(new Transformer());
    }
}
