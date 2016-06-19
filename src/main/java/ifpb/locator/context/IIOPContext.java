package ifpb.locator.context;

import ifpb.locator.ConfigContext;
import ifpb.locator.context.CorbaContext;
import ifpb.locator.context.DefaultContext;
import ifpb.locator.context.ProviderContext;
import ifpb.locator.context.ProviderContext.Provider;
import java.util.Properties;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:46:23
 */
public class IIOPContext implements ConfigContext {

    private final ConfigContext config;

    public IIOPContext() {
        this(
                new CorbaContext(
                        new ProviderContext(
                                new DefaultContext("127.0.0.1", "1050"),Provider.IIOP)
                )
        );
    }

    public IIOPContext(final ConfigContext config) {
        this.config = config;
    }

    @Override
    public Properties properties() {
        Properties properties = new Properties();
        properties.putAll(config.properties());
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.cosnaming.CNCtxFactory");
        return properties;
    }

}
