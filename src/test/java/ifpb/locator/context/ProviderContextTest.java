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
public class ProviderContextTest {

    private ProviderContext instance;
    private ConfigContext config = new DefaultContext("192.168.99.100", "8080");
    
    @Test
    public void testPropertiesRemote() {
        System.out.println("testPropertiesRemote");
        instance = new ProviderContext(config);
        Properties result = instance.properties();
        String providerResult = Provider.HTTP_REMOTING.of();
        String urlProviderResult = "http-remoting://192.168.99.100:8080";

        assertNotNull("values null in properties", result);
        assertEquals(providerResult, instance.provider());
        assertEquals(urlProviderResult, instance.urlProvider());

    }

    @Test
    public void testProperties() {
        System.out.println("testProperties");
        instance = new ProviderContext(config, Provider.HTTP);
        Properties result = instance.properties();
        String expResult = Provider.HTTP.of();
        
        String urlProviderResult = "http://192.168.99.100:8080";
        
        assertNotNull("values null in properties", result);
        assertEquals(expResult, instance.provider());
        assertEquals(urlProviderResult, instance.urlProvider());

    }

}
