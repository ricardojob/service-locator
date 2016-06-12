package ifpb.ads.service.glassfish;

import ifpb.ads.service.glassfish.ProviderContext.Provider;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Job
 */
public class GlassFishContextTest {

    private GlassFishContext instance;
    private ConfigContext config = new DefaultContext("192.168.99.100", "3700");
    
    @Test
    public void testPropertiesRemote() {
        System.out.println("testPropertiesRemote");
        instance = new GlassFishContext(config);
        Properties result = instance.properties();
        String portResult = "3700";
        String hostResult = "192.168.99.100";
        String factoryResult = "com.sun.enterprise.naming.SerialInitContextFactory";

        assertNotNull("values null in properties", result);
        assertEquals(portResult, result.getProperty("org.omg.CORBA.ORBInitialHost"));
        assertEquals(hostResult, result.getProperty("org.omg.CORBA.ORBInitialPort"));
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));
    }

    

}
