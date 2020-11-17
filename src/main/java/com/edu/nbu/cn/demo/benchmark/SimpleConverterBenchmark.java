package com.edu.nbu.cn.demo.benchmark;

import com.edu.nbu.cn.beancopy.SimpleBeanConverter;
import com.edu.nbu.cn.beancopy.cglibcopier.CglibCopierUtils;
import com.edu.nbu.cn.beancopy.dozer.DozerBeanUtils;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBean;
import com.edu.nbu.cn.beancopy.model.simple.SimpleBeanDTO;
import com.edu.nbu.cn.beancopy.orika.core.OrikaUtils;
import com.edu.nbu.cn.beancopy.spring.SpringBeanUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.Throughput,Mode.AverageTime,Mode.SingleShotTime})
@Threads(1)
@State(Scope.Thread)
@Measurement(time = 1,iterations=5)
@Timeout(time=10,timeUnit = TimeUnit.SECONDS)
public class SimpleConverterBenchmark {
    private static SimpleBean simpleBean = SimpleBean.instance();

    @Benchmark
    public void baseLine(){
        SimpleBeanDTO dto = SimpleBeanConverter.convertToDTO(simpleBean);
    }

    @Benchmark
    public void apacheBeanUtils() throws InvocationTargetException, IllegalAccessException {
        SimpleBeanDTO beanDTO = new SimpleBeanDTO();
        BeanUtils.copyProperties(beanDTO,simpleBean);
    }

    @Benchmark
    public void cglibCopier(){
        SimpleBeanDTO beanDTO = new SimpleBeanDTO();
        CglibCopierUtils.copy(SimpleBean.class,SimpleBeanDTO.class,simpleBean,beanDTO);
    }

    @Benchmark
    public void dozer(){
        DozerBeanUtils.convert(simpleBean,SimpleBeanDTO.class);
    }


    @Benchmark
    public void orika(){
        OrikaUtils.map(simpleBean,SimpleBeanDTO.class);
    }

    @Benchmark
    public void springBeanUtils(){
        SimpleBeanDTO dto = new SimpleBeanDTO();
        SpringBeanUtils.copy(simpleBean,dto);
    }
}
