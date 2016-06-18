package ifpb.locator.named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/06/2016, 13:15:59
 */
public enum Scoped {
    EMPTY(""),
    MODULE("java:module"),
    APP("java:app"),
    GLOBAL("java:global");

    private String prefix;

    private Scoped(String scope) {
        this.prefix = scope;
    }

    @Override
    public String toString() {
        return this.prefix;
    }
  

}
