package nomes;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 01:51:15
 */
public class BeanLocator<T> {

    public BeanLocator bean(String bean){
        return new BeanLocator();
    }
    public BeanLocator<T> withInterface(Class<T> clazz){
        return new BeanLocator();
    }
}
