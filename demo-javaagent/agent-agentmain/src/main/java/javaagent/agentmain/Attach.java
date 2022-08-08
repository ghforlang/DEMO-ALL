package javaagent.agentmain;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/3-3:12 PM
 * @since 1.0
 */
public class Attach {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException, InterruptedException {
        String agentPath = "/Users/fanwenhao/my-projects/DEMO-ALL/demo-javaagent/agent-agentmain/target/agent-agentmain-1.0-SNAPSHOT.jar";
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for(VirtualMachineDescriptor descriptor : list){
            if(descriptor.displayName().endsWith("People2")){
                VirtualMachine vm = VirtualMachine.attach(descriptor.id());
                for(int i=0;i<10;i++){
                    TimeUnit.SECONDS.sleep(1);
                    vm.loadAgent(agentPath);
                }
                vm.detach();
            }
        }
    }
}
