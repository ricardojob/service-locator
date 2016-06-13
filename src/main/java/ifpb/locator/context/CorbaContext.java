package ifpb.locator.context;

import ifpb.locator.ConfigContext;
import java.util.Properties;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:52:02
 */
public class CorbaContext implements ConfigContext {

    private final ConfigContext context;
    

    public CorbaContext(ConfigContext defaultContex) {
        this.context = defaultContex;
    }
 
    @Override
    public Properties properties() {
        Properties prop = context.properties();
        String host = prop.getProperty("host", "127.0.0.1");
        String port = prop.getProperty("port", "8080");
        Properties properties = new Properties();
        properties.putAll(prop);
        properties.setProperty("org.omg.CORBA.ORBInitialHost", host);
        properties.setProperty("org.omg.CORBA.ORBInitialPort", port);
        return properties;
    }

      
}
