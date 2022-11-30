package calculator;

import calculator.panels.CalculationButtonsPanel;
import calculator.panels.DisplayPanel;
import calculator.panels.OperationsPanel;
import calculator.panels.ProcessPanel;
import calculator.state.CalculatorState;

import javax.swing.JFrame;

public class Calculator extends JFrame {
    public Calculator() {
        CalculatorState calculatorState = new CalculatorState();
        new CalculationButtonsPanel(this, calculatorState);
        new DisplayPanel(this, calculatorState);
        new ProcessPanel(this, calculatorState);
        new OperationsPanel(this, calculatorState);
    }
}
