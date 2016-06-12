package nomes;

import ifpb.ads.context.ConfigContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 01:51:15
 */
public class BeanLocator<T> {

    private StringBuilder builder;
    private Class<T> clazz;
//    private Module module;
//    private ConfigContext context;

    private ServerContext context;

    public BeanLocator(ServerContext context) {
        this.context = context;
        builder = new StringBuilder();
    }

    private BeanLocator(ServerContext context, String bean) {
        this(context);
        builder.append(bean);
    }

    private BeanLocator(ServerContext context, String bean, Class<T> clazz) {
        this(context, bean);
        this.clazz = clazz;
        builder.append("!").append(clazz.getName());
    }

    public BeanLocator<T> withInterface(Class<T> clazz) {
        return new BeanLocator(this.context, this.builder.toString(), clazz);
    }

    public BeanLocator bean(String bean) {
        return new BeanLocator(this.context, bean);
    }

    public String name() {
        return this.context.app().of() + "/" + builder.toString();
    }

    public T locate() {
        return this.context.lookup(name(), clazz);
    }
}
