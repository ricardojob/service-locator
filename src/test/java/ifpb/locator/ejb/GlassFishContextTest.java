package ifpb.locator.ejb;


import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

import ifpb.locator.context.DefaultContext;
import ifpb.locator.ConfigContext;
/**
 *
 * @author Ricardo Job
 */
public class GlassFishContextTest {

    private GlassFishContext instance;
    private ConfigContext config = new DefaultContext("192.168.99.100", "3700");

    @Test
    public void testProperties() {
        System.out.println("testProperties");
        instance = new GlassFishContext();
        Properties result = instance.properties();
        String portResult = "3700";
        String hostResult = "127.0.0.1";
        String factoryResult = "com.sun.enterprise.naming.SerialInitContextFactory";

        assertNotNull("values null in properties", result);
        assertEquals(hostResult, result.getProperty("org.omg.CORBA.ORBInitialHost"));
        assertEquals(portResult, result.getProperty("org.omg.CORBA.ORBInitialPort"));
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));
    }
    @Test
    public void testPropertiesRemote() {
        System.out.println("testPropertiesRemote");
        instance = new GlassFishContext(config);
        Properties result = instance.properties();
        String factoryResult = "com.sun.enterprise.naming.SerialInitContextFactory";

        assertNotNull("values null in properties", result);
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));
    }

}
