package cn.edu.nbu.protobuf.demo;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/10-4:55 PM
 * @since 1.0
 */
@ProtobufClass
@Getter
@Setter
@Builder
public class Person {
    @Protobuf(fieldType = FieldType.STRING,order=1)
    private String name;
    @Protobuf(fieldType = FieldType.UINT32,order=2)
    private Integer age;
    @Protobuf(fieldType = FieldType.OBJECT,order=3)
    private Gender gender;
    @Protobuf(fieldType = FieldType.FLOAT,order=4)
    private Float height;
    @Protobuf(fieldType = FieldType.DOUBLE,order=5)
    private Double weight;
    @Protobuf(fieldType = FieldType.OBJECT,order=6)
    private Location personLocation;




    @ProtobufClass
    public enum Gender{
        MAN(0),WOMAN(1);

        @Protobuf(fieldType = FieldType.UINT32,order=1)
        private final Integer value;

        Gender(Integer value) {
            this.value = value;
        }

        public Integer toValue(){
            return this.value;
        }

        public Integer value(){
            return toValue();
        }
    }

    @ProtobufClass
    @Getter
    @Setter
    @Builder
    public static class Location{
        @Protobuf(fieldType = FieldType.STRING,order=1)
        private String placeName;
        @Protobuf(fieldType = FieldType.UINT64,order=2)
        private Long placeId;

    }
}
