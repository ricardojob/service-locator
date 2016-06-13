package ifpb.locator.ejb;

import ifpb.locator.ConfigContext;
import ifpb.locator.context.CorbaContext;
import ifpb.locator.context.DefaultContext;
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
        this(new CorbaContext(new DefaultContext("127.0.0.1", "3700")));
    }

    public GlassFishContext(final ConfigContext config) {
        this.config = config;
    }

    @Override
    public Properties properties() {
        Properties properties = new Properties();
        properties.putAll(config.properties());
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.enterprise.naming.SerialInitContextFactory");
        return properties;
    }

}
