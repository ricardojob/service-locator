package ifpb.locator.context;

import ifpb.locator.ConfigContext;
import ifpb.locator.context.ProviderContext.Provider;
import java.util.Properties;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:46:23
 */
public class RMIContext implements ConfigContext {

    private final ConfigContext config;

    public RMIContext() {
        this("127.0.0.1", "1099");
    }

    public RMIContext(String host, String port) {
        this(
            new ProviderContext(
                new DefaultContext(host, port), Provider.RMI)
        );
    }

    public RMIContext(final ConfigContext config) {
        this.config = config;
    }

    @Override
    public Properties properties() {
        Properties properties = new Properties();
        properties.putAll(config.properties());
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.rmi.registry.RegistryContextFactory");
        return properties;
    }

}
