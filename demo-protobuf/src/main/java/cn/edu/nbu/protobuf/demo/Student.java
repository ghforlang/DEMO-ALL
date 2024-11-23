package cn.edu.nbu.protobuf.demo;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/10-4:53 PM
 * @since 1.0
 */
@Getter
@Setter
@ProtobufClass
@Builder
public class Student {
    @Protobuf(fieldType = FieldType.OBJECT,order=1)
    private Person person;
    @Protobuf(fieldType = FieldType.UINT32,order = 2)
    private Integer classId;
    @Protobuf(fieldType = FieldType.UINT32,order = 3)
    private Integer score;
}
