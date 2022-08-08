package javaagent.agentmain;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-3:01 PM
 * @since 1.0
 */
public class Transform implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println(String.format("agent run target class=%s",className));
        return classfileBuffer;
    }
}
