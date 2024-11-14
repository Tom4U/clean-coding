package cleancode.methode;

import java.util.List;

public class ReadableMethods {
    private List<ActionConfiguration> registeredActions;

    public void addActionToNavigation(JaspiraAction jaspiraAction) {
        ActionConfiguration registeredAction = getRegisteredAction(jaspiraAction);

        increaseReferenceCounterOfAction(registeredAction.getAction());

        addActionToMenu(registeredAction.getAction());

        addActionToToolbar(registeredAction.getAction());
    }

    private ActionConfiguration getRegisteredAction(JaspiraAction action) {
        ActionConfiguration actionConfiguration = ActionConfiguration.fromActionAndName(action, action.getName());

        assureActionExists(actionConfiguration);

        int registeredActionIndex = registeredActions.indexOf(actionConfiguration);

        return registeredActions.get(registeredActionIndex);
    }

    private void increaseReferenceCounterOfAction(JaspiraAction action) {
        action.increaseCounter();
    }

    private void assureActionExists(ActionConfiguration action) {
        if (action.getAction() == null) {
            registeredActions.add(action);
        }
    }

    private void addActionToMenu(JaspiraAction action) {
        String menuParentName = action.getActionPropertyString(JaspiraAction.PROPERTY_MENU_PARENT);

        if (menuParentName != null) {
            addActionToMenuParent(ActionConfiguration.fromActionAndName(action, menuParentName));
        }
    }

    private void addActionToMenuParent(ActionConfiguration configuration) {
        JaspiraAction parent = findParentByConfiguration(configuration);

        parent.addMenuChild(configuration.getAction());
    }

    private JaspiraAction findParentByConfiguration(ActionConfiguration configuration) {
        JaspiraAction parent = getAction(configuration.getName());

        if (parent == null) {
            parent = createNewParent(configuration);
        }

        return parent;
    }

    private JaspiraAction createNewParent(ActionConfiguration configuration) {
        Object actionResource = configuration.getAction().getActionResource();
        JaspiraAction parent = new JaspiraAction(actionResource, configuration.getName());

        addActionToNavigation(parent);

        return parent;
    }

    private void addActionToToolbar(JaspiraAction action) {
        String toolbarParentName = action.getActionPropertyString(JaspiraAction.PROPERTY_TOOLBAR_PARENT);

        if (toolbarParentName != null) {
            addToolbarActionByConfiguration(ActionConfiguration.fromActionAndName(action, toolbarParentName));
        }
    }

    private void addToolbarActionByConfiguration(ActionConfiguration configuration) {
        JaspiraAction parent = findParentByConfiguration(configuration);

        parent.addToolbarChild(configuration.getAction());
    }

    // Wird nur benötigt, damit der Compiler im Editor keinen Fehler wirft
    private JaspiraAction getAction(String menuparentname) {
        return null;
    }

}
