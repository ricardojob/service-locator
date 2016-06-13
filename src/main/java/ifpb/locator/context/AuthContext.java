package ifpb.locator.context;

import ifpb.locator.ConfigContext;
import java.util.Properties;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:47:29
 */
public class AuthContext implements ConfigContext {

    private final ConfigContext context;
    private final String user;
    private final String password;

    public AuthContext(ConfigContext defaultContex, String user, String password) {
        this.context = defaultContex;
        this.password = password;
        this.user = user;
    }

    @Override
    public Properties properties() {
        Properties properties = new Properties();
        properties.putAll(context.properties());
        properties.put(Context.SECURITY_PRINCIPAL, user);
        properties.put(Context.SECURITY_CREDENTIALS, password);
        return properties;
    }

    public String user() {
        return user;
    }

    public String password() {
        return password;
    }
    

}
