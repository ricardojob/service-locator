package ifpb.ads.service.test;

import ifpb.ads.shared.Calculadora;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/06/2016, 15:38:11
 */
public class WildFly {

    public static void main(String[] args) {
//        String nome = "java:jboss/exported/core/CalculadoraImpl!ifpb.ads.shared.Calculadora";
        String nome = "/core/CalculadoraImpl!ifpb.ads.shared.Calculadora";
        Calculadora calculadora = lookup(nome, Calculadora.class);
        System.out.println(calculadora.somar(1, 5));
    }

    protected static <T> T lookup(String recurso, Class<T> tipo) {
        try {
            Properties props = new Properties();
//            props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming.remote.client.InitialContextFactory");
            
//            props.setProperty("jboss.naming.client.ejb.context", "true");
//            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
//            props.setProperty("org.omg.CORBA.ORBInitialPort", "1099");
//            props.put(Context.SECURITY_PRINCIPAL, "ricardojob");
//            props.put(Context.SECURITY_CREDENTIALS, "d00adaf652800fe22a22ec8a12c14609");
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://192.168.99.100:8080");
//            props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
            props.put(Context.SECURITY_PRINCIPAL, "ricardojob");
//            props.put(Context.SECURITY_CREDENTIALS, "am9iLjIwMTY=");
            props.put(Context.SECURITY_CREDENTIALS, "job.2016");
//job.2016  am9iLjIwMTY=
            props.put("jboss.naming.client.ejb.context", true);
            
            InitialContext context = new InitialContext(props);
            
//            NamingEnumeration<NameClassPair> list2 = context.list(context.getNameInNamespace());
//            while (list2.hasMore()) {
//                System.out.println(list2.next());
//            }
            return (T) context.lookup(recurso);

        } catch (NamingException ne) {

            ne.printStackTrace();
            throw new RuntimeException(ne);
        }
    }
}
