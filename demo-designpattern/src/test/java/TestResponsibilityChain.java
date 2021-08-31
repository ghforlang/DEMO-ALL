import com.edu.nbu.cn.designpattern.responsibilitychain.ResponsibilityChain;
import com.edu.nbu.cn.designpattern.responsibilitychain.chain.DayConsumerTimesFilterChain;
import com.edu.nbu.cn.designpattern.responsibilitychain.chain.MouslimConsumerFilterChain;
import com.edu.nbu.cn.designpattern.responsibilitychain.chain.SpecialConsumerFilterChain;
import com.edu.nbu.cn.designpattern.responsibilitychain.consumer.Consumer;
import com.edu.nbu.cn.designpattern.responsibilitychain.consumer.OtherConsumer;
import com.edu.nbu.cn.designpattern.responsibilitychain.consumer.StudentConsumer;
import com.edu.nbu.cn.designpattern.responsibilitychain.consumer.TeacherConsumer;

import java.util.ArrayList;
import java.util.List;

public class TestResponsibilityChain {

    public static void main(String[] args) {
        ResponsibilityChain chain = new ResponsibilityChain();
        chain.addFilter(new SpecialConsumerFilterChain());
        chain.addFilter(new DayConsumerTimesFilterChain());
        chain.addFilter(new MouslimConsumerFilterChain());

        List<Consumer> consumers = new ArrayList<>();
        consumers.add(buildStudentConsumer());
        consumers.add(buildTeacherConsumer());
        consumers.add(buildMousimConsumer());
        consumers.forEach(consumer -> chain.doFilter(consumer));
    }

    public static StudentConsumer buildStudentConsumer(){
        StudentConsumer sc = new StudentConsumer(1,"学生");
        return sc;
    }

    public static TeacherConsumer buildTeacherConsumer(){
        TeacherConsumer tc = new TeacherConsumer(2,"老师");
        return tc;
    }

    public static OtherConsumer buildMousimConsumer(){
        OtherConsumer oc = new OtherConsumer(3,"其他");
        return oc;
    }


}
