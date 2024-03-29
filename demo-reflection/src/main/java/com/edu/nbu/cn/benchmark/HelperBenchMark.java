package com.edu.nbu.cn.benchmark;


import com.edu.nbu.cn.reflection.javassist.AbstractEntityHelper;
import com.edu.nbu.cn.reflection.javassist.HelperFactory;
import com.edu.nbu.cn.reflection.Param;
import com.edu.nbu.cn.reflection.Student;
import com.edu.nbu.cn.reflection.StudentHelper;
import com.edu.nbu.cn.reflection.StudentReflectionHelper;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.Throughput,Mode.AverageTime,Mode.SingleShotTime})
@Threads(1)
@State(Scope.Thread)
@Timeout(time=1,timeUnit = TimeUnit.MINUTES)
@Measurement(time = 1,iterations=5)
public class HelperBenchMark {

    private static final Param param = new Param();

    static{
        param.setAddress("上海");
        param.setAge(10);
        param.setName("张三");
    }


    @Warmup(iterations = 3)
    @Benchmark
    public void baseLine(){
        StudentHelper helper = new StudentHelper();
        helper.create(param);
    }

    @Warmup(iterations = 3)
    @Benchmark
    public void javassistImpl() throws IOException, CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException {
        AbstractEntityHelper studentHelper = HelperFactory.createEntityHelper(Student.class);
        studentHelper.create(param);
    }


    @Warmup(iterations = 3)
    @Benchmark
    public void reflectionImpl() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        StudentReflectionHelper.create(param);
    }

    @Warmup(iterations = 3)
    @Benchmark
    public void reflectionImpl2() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        StudentReflectionHelper reflectionHelper = new StudentReflectionHelper();
        reflectionHelper.createStudent(param);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HelperBenchMark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
