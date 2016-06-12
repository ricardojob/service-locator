package nomes;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 01:51:15
 */
public class BeanLocator<T> {
    private StringBuilder builder;

    public BeanLocator(String bean) {
        builder = new StringBuilder(bean);
    }

    private BeanLocator(String bean, Class<T> clazz) {
        this(bean);
        builder.append("!").append(clazz.getName());
    }

    public BeanLocator<T> withInterface(Class<T> clazz) {
        return new BeanLocator(this.builder.toString(), clazz);
    }

    public String name() {
        return builder.toString();
    }

    public T locate() {
        return null;
    }
}
