package cleancode.methode;

import java.util.Map;

public class ReadableMethods {
    private Map<String, JaspiraAction> actions;

    /**
     * Add a new Action to the manager. Returns true if the action is already
     * existant. If the action is already registered, it is NOT replaced.
     *
     * @param action the action to add
     */
    public void addAction(JaspiraAction action) {
        String name = action.getName();

        JaspiraAction current = (JaspiraAction) actions.get(name);

        if (current == null) {
            // Action not present yet, add to list current = action;
            actions.put(name, current);
        }

        // Increase reference counter
        current.increaseCounter();

        // Add as child to the menu parent if given
        String menuparentname = current.getActionPropertyString(JaspiraAction.PROPERTY_MENU_PARENT);

        if (menuparentname != null) {
            // Check if the parent has already been registered
            JaspiraAction menuparent = getAction(menuparentname);

            if (menuparent == null) {
                menuparent = new JaspiraAction(current.getActionResource(), menuparentname);
                addAction(menuparent);
            }

            // register this action at its parent
            menuparent.addMenuChild(current);
        }

        // Add as child to the toolbar parent if given
        String toolbarparentname = current.getActionPropertyString(JaspiraAction.PROPERTY_TOOLBAR_PARENT);

        if (toolbarparentname != null) {
            // Check if the parent has already been registered
            JaspiraAction toolbarparent = getAction(toolbarparentname);

            if (toolbarparent == null) { // No, create it on the fly
                toolbarparent = new JaspiraAction(current.getActionResource(), toolbarparentname);
                addAction(toolbarparent);
            }

            // register this action at its parent
            toolbarparent.addToolbarChild(current);
        }
    }

    // Wird nur benötigt, damit der Compiler im Editor keinen Fehler wirft
    private JaspiraAction getAction(String menuparentname) {
        return null;
    }

}
