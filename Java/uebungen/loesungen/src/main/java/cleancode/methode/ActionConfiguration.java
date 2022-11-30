package cleancode.methode;

public final class ActionConfiguration {
    private JaspiraAction action;
    private String name;

    private ActionConfiguration(JaspiraAction action, String name) {
        this.action = action;
        this.name = name;
    }

    public static ActionConfiguration fromActionAndName(JaspiraAction action, String name) {
        return new ActionConfiguration(action, name);
    }

    public JaspiraAction getAction() {
        return action;
    }

    public String getName() {
        return name;
    }
}
