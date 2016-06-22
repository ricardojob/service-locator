package ifpb.locator.ejb;

import ifpb.locator.ConfigContext;
import ifpb.locator.context.DefaultContext;
import ifpb.locator.context.ProviderContext;
import java.util.Properties;
import java.util.function.BiConsumer;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:46:23
 */
public class WildflyContext implements ConfigContext {

    private final ConfigContext config;

    public WildflyContext() {
        this("127.0.0.1", "8080");
    }
    public WildflyContext(String host, String port) {
        this(new ProviderContext(new DefaultContext(host, port)));
    }

    public WildflyContext(final ConfigContext config) {
        this.config = config;
    }

    @Override
    public Properties properties() {
        Properties properties = new Properties();
        properties.putAll(config.properties());
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        return properties;
    }

}
