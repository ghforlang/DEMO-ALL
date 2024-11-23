package cn.edu.nbu.protobuf.demo;

import cn.edu.nbu.protobuf.utils.FileOperationUtils;
import com.baidu.bjf.remoting.protobuf.Any;
import edu.emory.mathcs.backport.java.util.Arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/10-4:37 PM
 * @since 1.0
 */
public class Test {
    private static final String path = "/Users/fanwenhao/my-projects/DEMO-ALL/demo-protobuf/src/main/java/cn/edu/nbu/protobuf/demo/test.pack";
    public static void main(String[] args) throws IOException {
        protoBuff(path);
    }

    public static void protoBuff(String path) throws IOException {
        School school = buildSchool(path);
        byte[] bytes = school.getExtend().getByteArray();;
        System.out.println("protobuf序列化后:" + Arrays.toString(bytes));
//        byte[] readBytes = FileOperationUtils.readFileByte(path);
//        System.out.println("protobuf反序列化后:" + school.parseFromBytes(bytes));

    }

    public void jProtoBuff(String path){
//        School school = buildSchool(path);
    }

    private static School buildSchool(String path) throws IOException {
        Person person = new Person.PersonBuilder()
                .name("张三")
                .age(10)
                .height(1.75F)
                .weight(100.0D)
                .gender(Person.Gender.MAN)
                .personLocation(Person.Location.builder()
                        .placeId(12413L)
                        .placeName("taiwan")
                        .build())
                .build();


        List<Student> students = new ArrayList<>();
        students.add(new Student.StudentBuilder()
                .person(person)
                .classId(11)
                .score(120)
                .build());
        School school = new School.SchoolBuilder()
                .isOpen(true)
                .schoolLocation(School.Location.builder()
                        .id(12412)
                        .name("taiwan")
                        .build())
                .allStudents(students)
                .build();
        school.setExtend(Any.pack(school));
        return school;
    }
}
