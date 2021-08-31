package com.edu.nbu.cn.beancopy.benchmark;

import com.edu.nbu.cn.beancopy.StudentSimpleConverter;
import com.edu.nbu.cn.beancopy.apache.StudentBeanCopyUtils;
import com.edu.nbu.cn.beancopy.dozer.DozerBeanUtils;
import com.edu.nbu.cn.beancopy.model.StudentBO;
import com.edu.nbu.cn.beancopy.model.StudentDTO;
import com.edu.nbu.cn.beancopy.orika.converter.StudentBeanConverter;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.Throughput, Mode.AverageTime,Mode.SingleShotTime})
@Threads(1)
@State(Scope.Thread)
@Measurement(time = 1,iterations=5)
@Timeout(time=1,timeUnit = TimeUnit.MINUTES)
public class ComplexConverterBenchmark {

    private static StudentBO student = StudentBO.newInstance();
    private static String filePath = "dozer-demo-mapper.xml";

    @Benchmark
    public void baseLine(){
        StudentDTO dto = StudentSimpleConverter.convertToDTO(student);
    }

    @Benchmark
    public void apacheBeanUtils() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        StudentDTO studentDTO = StudentBeanCopyUtils.copy(student);
    }

    @Benchmark
    public void dozerUtils(){
        StudentDTO dto = DozerBeanUtils.convert(student,StudentDTO.class,filePath);
    }

    @Benchmark
    public void orikaUtils(){
        StudentDTO dto = StudentBeanConverter.convertToStudentDTO(student);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ComplexConverterBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
