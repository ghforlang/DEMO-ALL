package javapoet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @version 1.0
 * @Date 2021/2/5 5:38 下午
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface JavaPoet {
    /**
     * default value
     * @return
     */
    String value() default "default";
}
