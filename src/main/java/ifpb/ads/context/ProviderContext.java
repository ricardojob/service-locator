package ifpb.ads.context;

import java.util.Properties;
import javax.naming.Context;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 23:52:02
 */
public class ProviderContext implements ConfigContext {

    private final ConfigContext context;
    private final Provider provider;
    private String url;

    public ProviderContext(ConfigContext defaultContex) {
        this(defaultContex, Provider.HTTP_REMOTING);
    }

    protected ProviderContext(ConfigContext defaultContex, Provider provider) {
        this.context = defaultContex;
        this.provider = provider;
    }

    @Override
    public Properties properties() {
        Properties prop = context.properties();
        String host = prop.getProperty("host", "127.0.0.1");
        String port = prop.getProperty("port", "8080");

        url = new StringBuilder(this.provider.of())
                .append("//")
                .append(host)
                .append(":")
                .append(port)
                .toString();

        Properties properties = new Properties(prop);
      
        properties.put(Context.PROVIDER_URL, url);
        return properties;
    }

    protected String provider() {
        return provider.of();
    }

    protected String urlProvider() {
        return this.url;
    }

    enum Provider {
        HTTP("http:"),
        HTTP_REMOTING("http-remoting:");

        private final String provider;

        private Provider(final String provider) {
            this.provider = provider;
        }

        public String of() {
            return this.provider;
        }
    }
}
