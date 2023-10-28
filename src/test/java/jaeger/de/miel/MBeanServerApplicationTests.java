package jaeger.de.miel;

import jaeger.de.miel.mbeans.HelloMBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MBeanServerApplicationTests {

	@Autowired
	HelloMBean helloMBean;


	@Test
	void testHelloMBean() {
		assertEquals("Hello world", helloMBean.hello("world"));
	}

}
