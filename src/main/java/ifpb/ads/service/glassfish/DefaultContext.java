package ifpb.ads.service.glassfish;

import java.util.Properties;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:47:29
 */
class DefaultContext implements ConfigContext {

    private final Properties properties = new Properties();

    private final String host;
    private final String port;

    protected DefaultContext(final String host, final String port) {
        this.port = port;
        this.host = host;
    }

    @Override
    public Properties properties() {
        properties.put("host", host);
        properties.put("port", port);
        return properties;
    }

    protected String host() {
        return host;
    }

    protected String port() {
        return port;
    }
    

}
