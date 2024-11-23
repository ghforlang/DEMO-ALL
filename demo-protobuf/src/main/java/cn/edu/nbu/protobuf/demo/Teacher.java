package cn.edu.nbu.protobuf.demo;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/10-5:09 PM
 * @since 1.0
 */
@ProtobufClass
@Getter
@Setter
public class Teacher {
    private Integer id;
    private String name;

}
