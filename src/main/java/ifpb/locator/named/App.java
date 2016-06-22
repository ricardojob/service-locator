package ifpb.locator.named;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 02:36:08
 */
public class App {

    private Optional<String> app;
    private Optional<String> module;
    private Optional<Scoped> scope;

    private App(String app) {
        this(app, null);
    }

    private App(String app, String module) {
        this(app, module, Scoped.GLOBAL);
    }

    public App(String app, String module, Scoped scope) {
        this.app = Optional.ofNullable(app);
        this.module = Optional.ofNullable(module);
        this.scope = Optional.ofNullable(scope);
    }

    public static App name(String name) {
        return new App(name);
    }

    public App module(String name) {
        return new App(this.app.get(), name);
    }

    public App namespace(Scoped scope) {
        return new App(this.app.orElse(null), this.module.orElse(null), scope);
    }

    protected String of() {
        final StringBuilder builder = new StringBuilder();
        scope.filter(t -> !t.equals(Scoped.EMPTY))
                .ifPresent(t -> builder.append(scope.get()));
        app.ifPresent(t -> builder.append("/").append(app.get()));
        module.ifPresent(t -> builder.append("/").append(module.get()));
        
//        Optional<String> retorno = Optional.of(builder.toString());
//        return retorno
//                .filter(t -> "".equals(t.trim()))
//                .orElse(builder.append("/").toString());

        return builder.toString();
    }
}
