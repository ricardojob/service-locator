package ifpb.ads.service.glassfish;

import ifpb.ads.service.glassfish.ProviderContext.Provider;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Job
 */
public class AuthContextTest {

    private AuthContext instance;
    private ConfigContext config = new DefaultContext("192.168.99.100", "8080");
    
    @Test
    public void testProperties() {
        System.out.println("testPropertiesRemote");
        instance = new AuthContext(config, "ricardojob", "job.2016");
        Properties result = instance.properties();
        String userResult = "ricardojob";
        String passResult = "job.2016";

        assertNotNull("values null in properties", result);
        assertEquals(userResult, instance.user());
        assertEquals(passResult, instance.password());

    }

     
}
