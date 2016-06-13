package ifpb.locator.ejb;

import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;
import ifpb.locator.ConfigContext;
import ifpb.locator.context.AuthContext;
import ifpb.locator.context.DefaultContext;
import ifpb.locator.context.ProviderContext;

/**
 *
 * @author Ricardo Job
 */
public class WildflyContextTest {

    private WildflyContext instance;
    private final ConfigContext config = new DefaultContext("192.168.99.100", "8080");

    @Test
    public void testProperties() {
        System.out.println("testProperties");
        instance = new WildflyContext(config);
        Properties result = instance.properties(); 
        boolean contextResult = true;
        String factoryResult = "org.jboss.naming.remote.client.InitialContextFactory";

        assertNotNull("values null in properties", result);
        assertEquals(contextResult, result.get("jboss.naming.client.ejb.context")); 
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));
    }

    @Test
    public void testPropertiesProvider() {
        System.out.println("testPropertiesRemote");
        instance = new WildflyContext(new ProviderContext(config));
        Properties result = instance.properties();
        boolean contextResult = true;
        String factoryResult = "org.jboss.naming.remote.client.InitialContextFactory";       
        String urlProviderResult = "http-remoting://192.168.99.100:8080";

        assertNotNull("values null in properties", result);
        assertEquals(contextResult, result.get("jboss.naming.client.ejb.context"));
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));        
        assertEquals(urlProviderResult, result.getProperty("java.naming.provider.url"));
    }
    @Test
    public void testPropertiesAuth() {
        System.out.println("testPropertiesRemote");
        instance = new WildflyContext(new AuthContext(config, "ricardo", "job"));
        Properties result = instance.properties();
        boolean contextResult = true;
        String factoryResult = "org.jboss.naming.remote.client.InitialContextFactory";       
        String userResult = "ricardo";
        String passResult = "job";

        assertNotNull("values null in properties", result);
        assertEquals(contextResult, result.get("jboss.naming.client.ejb.context"));
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));        
        assertEquals(userResult, result.getProperty("java.naming.security.principal"));        
        assertEquals(passResult, result.getProperty("java.naming.security.credentials"));        
        
    }

}
