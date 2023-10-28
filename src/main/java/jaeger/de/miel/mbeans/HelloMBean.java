package jaeger.de.miel.mbeans;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
public class HelloMBean implements HelloMBeanMXBean {

    @ManagedOperation
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "msg", description = "Message")
    })
    public String hello(String msg) {
        return "Hello " + msg;
    }

}