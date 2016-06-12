package nomes;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 02:09:09
 */
public class Cliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        System.out.println(cliente
                .bean("CalculadoraImpl")
                .withInterface(Cliente.class)
                .name());
        System.out.println(cliente
                .bean("CalculadoraImpl2")
                .name());
        
        System.out.println(cliente
                .app("ejb")
                .module("core")
                .global());;
        System.out.println(cliente
                .app("ejb")
                .global());;
     }
    
    public BeanLocator bean(String bean) {
        return new BeanLocator(bean);
    }
    
    public Module app(String app){
        return new Module(app);
    }
    
}
