package ifpb.locator.context;

import ifpb.locator.context.DefaultContext;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Job
 */
public class DefaultContextTest {

    private DefaultContext instance = new DefaultContext("127.0.0.1", "3700");

    @Test
    public void testProperties() {
        System.out.println("properties");
        Properties result = instance.properties();
        assertNotNull("values null in properties", result);
    }

    @Test
    public void testHost() {
        System.out.println("host");
        String expResult = "127.0.0.1";
        Properties result = instance.properties();
        assertEquals(result.getProperty("host"), expResult);
    }

   
    @Test
    public void testPort() {
        System.out.println("port");
        String expResult = "3700";
        Properties result = instance.properties();
        assertEquals(result.getProperty("port"), expResult);
    }

}
