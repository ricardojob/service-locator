package ifpb.locator.context;

import ifpb.locator.ConfigContext;
import ifpb.locator.context.ProviderContext.Provider;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Job
 */
public class RMIContextTest {

    private RMIContext instance;
    private ConfigContext config = new DefaultContext("192.168.99.100", "1090");

    @Test
    public void testPropertiesRemote() {
        System.out.println("testPropertiesRemote");
        instance = new RMIContext(config);
        Properties result = instance.properties();

        String portResult = "1090";
        String hostResult = "192.168.99.100";
        String factoryResult = "com.sun.jndi.rmi.registry.RegistryContextFactory";
        String urlProviderResult = "rmi://192.168.99.100:8080";

        assertNotNull("values null in properties", result);
        assertEquals(hostResult, result.getProperty("host"));
        assertEquals(portResult, result.getProperty("port"));
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));
        assertNotEquals(urlProviderResult, result.getProperty("java.naming.provider.url"));

    }
//java.naming.provider.url

    @Test
    public void testProperties() {
        System.out.println("testProperties");
        String portResult = "1090";
        String hostResult = "192.168.99.100";
        instance = new RMIContext(hostResult, portResult);

        Properties result = instance.properties();

        String factoryResult = "com.sun.jndi.rmi.registry.RegistryContextFactory";
        String urlProviderResult = "rmi://192.168.99.100:1090";

        assertNotNull("values null in properties", result);
        assertEquals(hostResult, result.getProperty("host"));
        assertEquals(portResult, result.getProperty("port"));
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));
        assertEquals(urlProviderResult, result.getProperty("java.naming.provider.url"));

    }

}
