package cn.edu.nbu.protobuf.demo;

import com.baidu.bjf.remoting.protobuf.Any;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/10-4:38 PM
 * @since 1.0
 */
@ProtobufClass
@Getter
@Setter
@Builder
public class School {

    @ProtobufClass
    @Getter
    @Setter
    @Builder
    static class Location{
        @Protobuf(fieldType = FieldType.STRING,order = 1)
        private String name;
        @Protobuf(fieldType = FieldType.UINT32,order =2)
        private Integer id;
    }

    @Protobuf(fieldType=FieldType.OBJECT,order=1)
    private Location schoolLocation;
    @Protobuf(fieldType = FieldType.BOOL,order=2)
    private Boolean isOpen;
    @Protobuf(fieldType = FieldType.OBJECT,order=3)
    private List<Student> allStudents;
    @Protobuf(fieldType = FieldType.OBJECT,order=4)
    private Any extend;


}
