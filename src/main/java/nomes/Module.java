package nomes;

import java.util.Optional;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 02:36:08
 */
public class Module {

    private Optional<String> app;
    private Optional<String> module;
    private String prefix = "java:global";

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
    
    public Module global(){
        this.prefix = "java:global";
        return this;
    }
    public Module app(){
        this.prefix = "java:app";
        return this;
    }
    public Module module(){
        this.prefix = "java:module";
        return this;
    }

    public String of() {    
        final StringBuilder builder = new StringBuilder(prefix);
        app.ifPresent(t -> builder.append("/").append(app.get()));
        module.ifPresent(t -> builder.append("/").append(module.get()));
        return builder.toString();//+app + "/" + module;
    }
}
