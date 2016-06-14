package ifpb.locator.named;

import java.util.Optional;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2016, 02:36:08
 */
public class App { //App

    private Optional<String> app;
    private Optional<String> module;
    private String prefix = "";

    private App(String app) {
        this(app, null);
    }

    private App(String app, String module) {
        this.app = Optional.ofNullable(app);
        this.module = Optional.ofNullable(module);
    }

    // Scope 
    public App module(String name) {
        return new App(this.app.get(), name);
    }
    public static App name(String name) {
        return new App(name);
    }
    
    public App global(){
        this.prefix = "java:global";
        return this;
    }
    public App app(){
        this.prefix = "java:app";
        return this;
    }
    public App module(){
        this.prefix = "java:module";
        return this;
    }

    public String of() {    
        final StringBuilder builder = new StringBuilder(prefix);
        app.ifPresent(t -> builder.append("/").append(app.get()));
        module.ifPresent(t -> builder.append("/").append(module.get()));
        return builder.toString();//+name + "/" + module;
    }
//    class Scope extends App{
//        
//        public Scope(String app) {
//            super(app);
//        }
//        
//        
//    }
}
