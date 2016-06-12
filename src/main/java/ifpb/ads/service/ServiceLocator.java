package ifpb.ads.service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2016, 18:48:06
 */
public class ServiceLocator implements Locator{

    private String jndiContext;

    private ServiceLocator() {
    }

    
    
    public ServiceLocator app(String app) {
        return this;
    }

    public ServiceLocator module(String app) {
        return this;
    }
    

//    class Locator {
//
//        private Context context;
//
//        public final <T> T lookup(String recurso, Class<T> tipo) throws InstantiationException {
//            try {
////            context = getContext();
//                return (T) context.lookup(recurso);
//            } catch (NamingException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//    }

//        String expected = "java:global/appName/moduleName/beanName#java.io.Serializable";
//        String actual = new BeanLocator.GlobalJNDIName().
//                withAppName("appName").
//                withModuleName("moduleName").
//                withBeanName("beanName").withBusinessInterface(Serializable.class).asString();
}
