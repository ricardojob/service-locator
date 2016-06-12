package ifpb.ads.locator;
 
import ifpb.ads.context.ConfigContext;
import ifpb.ads.context.DefaultContext;
import ifpb.ads.context.ProviderContext;
import java.util.Properties;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:46:23
 */
public class WildflyContext implements ConfigContext {

    private final ConfigContext config;

    public WildflyContext() {
        this(new ProviderContext(new DefaultContext("127.0.0.1", "8080")));
    }

    public WildflyContext(final ConfigContext config) {
        this.config = config;
    }

    @Override
    public Properties properties() {
        Properties properties = new Properties(config.properties()); 
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        return properties;
    }

}
