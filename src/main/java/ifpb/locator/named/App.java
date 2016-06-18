package ifpb.locator.named;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 02:36:08
 */
public class App { //App

    private Optional<String> app;
    private Optional<String> module;
    private Optional<Scoped> scope;
//    private String prefix = "";

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

//    public App global() {
//        this.prefix = "java:global";
//        return this;
//    }
//
//    public App app() {
//        this.prefix = "java:app";
//        return this;
//    }
//
//    public App module() {
//        this.prefix = "java:module";
//        return this;
//    }
    protected String of() {
        final StringBuilder builder = new StringBuilder();
//        scope.filter(t -> !t.equals(Scoped.EMPTY)).;
//        ifPresent(t -> builder.append(scope.get()));
        scope.filter(t -> !t.equals(Scoped.EMPTY))
                .ifPresent(t -> builder.append(scope.get()));
        app.ifPresent(t -> builder.append("/").append(app.get()));
        module.ifPresent(t -> builder.append("/").append(module.get()));
        return builder.toString();//+name + "/" + module;
    }

//    public class Module extends App {
//
//        private final Module MODULE_EMPTY = new Module("", "");
//
//        public Module(String app, String module) {
//            super(app, module);
//        }
//
//
//    }
}
