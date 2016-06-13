package ifpb.locator;

import java.util.Optional;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ifpb.locator.named.BeanLocator;
import ifpb.locator.named.Module;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 11:03:21
 */
public class ServerContext {

    private ConfigContext configContext;
    private Module module;
    private Optional<Context> contextServer = Optional.empty();

    public ServerContext(ConfigContext context, Module module) {
            this.configContext = context;
            this.module = module; 
    }

    public BeanLocator bean(String bean) {
        return new BeanLocator(this).bean(bean);
    }

    public Module app() {
        return this.module;
    }

    public ConfigContext context() {
        return configContext;
    }

    public <T> T lookup(String jndiResource, Class<T> type) {
        try {
            Context temp =  contextServer.orElse(new InitialContext(configContext.properties()));
            return (T) temp.lookup(jndiResource);
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
