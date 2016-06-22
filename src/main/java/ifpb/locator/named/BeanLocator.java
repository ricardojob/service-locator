package ifpb.locator.named;

import ifpb.locator.ServerContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 01:51:15
 */
public class BeanLocator {

    private StringBuilder builder;
    private Class clazz;

    private ServerContext context;

    public BeanLocator(ServerContext context) {
        this.context = context;
        builder = new StringBuilder();
    }

    private BeanLocator(ServerContext context, String bean) {
        this(context);
        builder.append(bean);
    }

    private BeanLocator(ServerContext context, String bean, Class clazz) {
        this(context, bean);
        this.clazz = clazz;
        builder.append("!").append(clazz.getName());
    }

    public BeanLocator withInterface(Class clazz) {
        return new BeanLocator(this.context, this.builder.toString(), clazz);
    }

    public BeanLocator bean(String bean) {
        return new BeanLocator(this.context, bean);
    }

    public String name() {
        String result = context.app().of().trim();
        if (!"".equals(result.trim())) { //TODO: retirar o if
            result += "/";
        }
        return result + builder.toString();
    }

    public <T> T locate() {
        return (T) this.context.lookup(name(), clazz);
    }
}
