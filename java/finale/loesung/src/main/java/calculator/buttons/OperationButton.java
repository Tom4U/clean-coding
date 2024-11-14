package calculator.buttons;

import calculator.buttons.listeners.AbstractButtonActionListener;

import javax.swing.JButton;

public class OperationButton {
    private JButton button;

    public OperationButton(String symbol, AbstractButtonActionListener actionListener) {
        button = new JButton(symbol);

        button.addActionListener(actionListener);
        button.setEnabled(true);
    }
}
