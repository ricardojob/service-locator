package nomes;

import ifpb.ads.context.ConfigContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 11:03:21
 */
public class ServerContext {

    private ConfigContext configContext;
    private Module module;
    private Context contextServer;

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
            this.contextServer = new InitialContext(configContext.properties());
            return (T) contextServer.lookup(jndiResource);
        } catch (NamingException ex) {
//            Logger.getLogger(ServerContext.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

}
