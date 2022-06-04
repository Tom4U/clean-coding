package uebungen.calculator;

import uebungen.calculator.panels.CalculationButtonsPanel;
import uebungen.calculator.panels.DisplayPanel;
import uebungen.calculator.panels.OperationsPanel;
import uebungen.calculator.panels.ProcessPanel;
import uebungen.calculator.state.CalculatorState;

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
