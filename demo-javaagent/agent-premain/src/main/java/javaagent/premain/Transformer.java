package javaagent.premain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-2:03 PM
 * @since 1.0
 */
public class Transformer implements ClassFileTransformer {
    private static final String CLASS_NAME = "javaagent.premain.SayHello";
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            try {
                if(className.endsWith("SayHello")) {
                    final ClassPool classPool = ClassPool.getDefault();
                    final CtClass ctClass = classPool.get(CLASS_NAME);
                    final CtMethod ctMethod = ctClass.getDeclaredMethod("sayHello");
                    String methodContent = "return \"hello agent !\";";
                    ctMethod.setBody(methodContent);
                    byte[] bytes = ctClass.toBytecode();
                    ctClass.detach();
                    return bytes;
                }
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        return new byte[0];
    }
}
