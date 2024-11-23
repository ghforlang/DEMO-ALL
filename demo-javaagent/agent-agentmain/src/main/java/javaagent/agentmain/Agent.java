package javaagent.agentmain;

import javax.sound.midi.Instrument;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-3:02 PM
 * @since 1.0
 */
public class Agent {
    public static void  agentmain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, UnmodifiableClassException {
        inst.addTransformer(new Transform(),true);
        inst.retransformClasses(Class.forName("javaagent.agentmain.People2"));
        printAllClassLoaders(inst);
    }

    private static void printAllClassLoaders(Instrumentation inst){
        Set<ClassLoader> allClassLoaders = new HashSet<ClassLoader>();
        Class<?>[] allLoadedClasses = inst.getAllLoadedClasses();
        for(Class<?> clazz : allLoadedClasses){
            allClassLoaders.add(clazz.getClassLoader());
        }
        for (ClassLoader classLoader : allClassLoaders) {
            System.out.println(classLoader.getClass().getName());
        }
    }
}
