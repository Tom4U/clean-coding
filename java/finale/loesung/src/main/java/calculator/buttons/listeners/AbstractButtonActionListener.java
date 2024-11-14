package calculator.buttons.listeners;

import calculator.helpers.ErrorDialog;
import calculator.state.CalculatorState;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractButtonActionListener implements ActionListener {
    private String symbol;
    private CalculatorState calculatorState;

    private JFrame mainFrame;

    protected AbstractButtonActionListener(String symbol, JFrame mainFrame, CalculatorState calculatorState) {
        this.symbol = symbol;
        this.mainFrame = mainFrame;
        this.calculatorState = calculatorState;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals(symbol)) {
            performOperation();
        }
    }

    protected void performOperation() {
        // Hook method
    }

    protected void showError() {
        ErrorDialog.showNoNumberError(mainFrame);
    }

    protected String getSymbol() {
        return symbol;
    }

    protected CalculatorState getCalculatorState() {
        return calculatorState;
    }
}
