package ifpb.locator.named;

import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

import ifpb.locator.ServerContext;
import ifpb.locator.ejb.GlassFishContext;

/**
 *
 * @author Ricardo Job
 */
public class ServerContextTest {

    private GlassFishContext context;
    private ServerContext server;
    private App module;

    @Test
    public void testServer() {
        System.out.println("testServer");
        context = new GlassFishContext();
        module =  App.name("ejb").namespace(Scoped.GLOBAL);
        
        server = new ServerContext(context, module);
        assertNotNull("values null in properties", server);
        
        String beanResult = "java:global/ejb/CalculadoraImpl!ifpb.locator.ServerContext";
        assertEquals(beanResult, server.bean("CalculadoraImpl")
                .withInterface(ServerContext.class).name());
        
        String noInterfaceResult = "java:global/ejb/CalculadoraImpl";
        assertEquals(noInterfaceResult, server
                .bean("CalculadoraImpl").name());
        String moduleResult = "java:global/ejb";
        assertEquals(moduleResult, server.app().of());

        String coreResult = "java:global/ejb/core";
        assertEquals(coreResult, server.app().module("core").namespace(Scoped.GLOBAL).of());
    }

    @Test
    public void testModule() {
        System.out.println("testModules");
        module = App.name("ejb").namespace(Scoped.EMPTY);
        assertNotNull("values null in properties", module);
        String moduleResult = "/ejb";
        assertEquals(moduleResult, module.of());
        App core = module.module("core").namespace(Scoped.GLOBAL);
        assertNotNull("values null in properties", core);
        String coreResult = "java:global/ejb/core";
        assertEquals(coreResult, core.of());
    }

    @Test
    public void testContext() {
        System.out.println("testProperties");
        context = new GlassFishContext();
        Properties result = context.properties();
        String factoryResult = "com.sun.enterprise.naming.SerialInitContextFactory";
        assertNotNull("values null in properties", result);
        assertEquals(factoryResult, result.getProperty("java.naming.factory.initial"));
    }

}
