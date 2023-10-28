package jaeger.de.miel;

import jaeger.de.miel.mbeans.HelloMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.management.*;
import java.lang.management.ManagementFactory;

@SpringBootApplication
public class MBeanServerApplication {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(MBeanServerApplication.class, args);

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        ObjectName objectName = new ObjectName("jaeger.de.miel.mbeans:name=helloMBean");
        HelloMBean helloMBean = (HelloMBean) applicationContext.getBean("helloMBean");
        server.registerMBean(helloMBean, objectName);

        while (true) {
            Thread.sleep(60000);
        }
    }

}
