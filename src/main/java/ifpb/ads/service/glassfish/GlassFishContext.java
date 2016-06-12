package ifpb.ads.service.glassfish;

import java.util.Properties;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:46:23
 */
public class GlassFishContext implements ConfigContext {

    private final ConfigContext config;

    public GlassFishContext() {
        this(new DefaultContext("127.0.0.1", "3700"));
    }

    public GlassFishContext(final ConfigContext config) {
        this.config = config;
    }

    @Override
    public Properties properties() {
        Properties prop = config.properties();
        String host = prop.getProperty("host", "127.0.0.1");
        String port = prop.getProperty("port", "3700");
        Properties properties = new Properties(prop);
        properties.setProperty("org.omg.CORBA.ORBInitialHost", host);
        properties.setProperty("org.omg.CORBA.ORBInitialPort", port);
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.enterprise.naming.SerialInitContextFactory");
        return properties;
    }

}
