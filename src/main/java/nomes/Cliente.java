package nomes;

import ifpb.ads.context.ConfigContext;
import ifpb.ads.locator.GlassFishContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 02:09:09
 */
public class Cliente {

    public static void main(String[] args) {
        ConfigContext context = new GlassFishContext();
        Module module = new Module("ejb");
        
        ServerContext cliente = new ServerContext(context, module);
        
        System.out.println(cliente
                .bean("CalculadoraImpl")
                .withInterface(Cliente.class)
                .name());
        System.out.println(cliente
                .bean("CalculadoraImpl2")
                .name());

        System.out.println(cliente
                .app()
                .module("core")
                .of());;
        System.out.println(cliente
                .app()
                .of());
        System.out.println(cliente
                .bean("CalculadoraImpl")
                .withInterface(Cliente.class)
                .name());
        System.out.println(cliente
                .bean("CalculadoraImpl")
//                .withInterface(Cliente.class)
                .name());
    }

}
