package nomes;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 02:36:08
 */
public class Module {

    private Optional<String> app;
    private Optional<String> module;

    protected Module(String app) {
        this(app, null);
    }

    private Module(String app, String module) {
        this.app = Optional.ofNullable(app);
        this.module = Optional.ofNullable(module);
    }

    public Module module(String module) {
        return new Module(this.app.get(), module);
    }

    public String global() {    
        final StringBuilder builder = new StringBuilder("java:globa");
        app.ifPresent(t -> builder.append("/").append(app.get()));
        module.ifPresent(t -> builder.append("/").append(module.get()));
        return builder.toString();//+app + "/" + module;
    }
}
