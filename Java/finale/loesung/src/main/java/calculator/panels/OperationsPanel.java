package calculator.panels;

// region Imports

import calculator.buttons.OperationButtonCollection;
import calculator.state.CalculatorState;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

// endregion

public class OperationsPanel extends AbstractPanel {
    private OperationButtonCollection operationButtonsCollection;

    public OperationsPanel(JFrame mainFrame, CalculatorState calculatorState) {
        super(mainFrame, BorderLayout.EAST, calculatorState);

        operationButtonsCollection = new OperationButtonCollection(calculatorState, mainFrame);

        setupButtons();
    }

    @Override
    protected void setupPanel() {
        final int rows = 4;
        final int columns = 1;

        setPanel(new JPanel(new GridLayout(rows, columns)));
    }

    @Override
    protected void enableButtons() {
        for (JButton button : operationButtonsCollection.getButtons()) {
            button.setEnabled(true);
        }
    }

    @Override
    protected void disableButtons() {
        for (JButton button : operationButtonsCollection.getButtons()) {
            button.setEnabled(false);
        }
    }

    private void setupButtons() {
        for (JButton button : operationButtonsCollection.getButtons()) {
            addButton(button);
        }
    }

    private void addButton(JButton button) {
        getPanel().add(button);
    }
}
