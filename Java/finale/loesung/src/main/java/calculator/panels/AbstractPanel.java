package calculator.panels;

// region Imports

import calculator.state.CalculatorState;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

// endregion

public abstract class AbstractPanel {
    private JPanel panel;
    private JFrame mainFrame;
    private CalculatorState calculatorState;

    protected AbstractPanel(JFrame mainFrame, String borderlayout, CalculatorState calculatorState) {
        this.calculatorState = calculatorState;

        setupPanel();

        configureMainFrame(mainFrame, borderlayout);

        runAfterPanelSetup();

        registerAllButtonsEnabledChange();
    }

    protected void setupPanel() {
        panel = new JPanel(new BorderLayout());
    }

    private void configureMainFrame(JFrame frame, String borderlayout) {
        mainFrame = frame;
        mainFrame.add(panel, borderlayout);
    }

    private void registerAllButtonsEnabledChange() {
        this.calculatorState.getChangeSupport().registerForAllButtonsEnabledChange(event -> {
            Boolean enable = (Boolean) event.getNewValue();

            if (Boolean.TRUE.equals(enable)) {
                enableButtons();
            } else {
                disableButtons();
            }
        });
    }

    // region Empty Hook Methods

    protected void runAfterPanelSetup() {
        // Hook method
    }

    protected void enableButtons() {
        // Hook method
    }

    protected void disableButtons() {
        // Hook method
    }

    // endregion

    // region Getter/Setter

    protected JPanel getPanel() {
        return panel;
    }

    protected void setPanel(JPanel panel) {
        this.panel = panel;
    }

    protected JFrame getMainFrame() {
        return mainFrame;
    }

    protected CalculatorState getCalculatorState() {
        return calculatorState;
    }

    // endregion
}
