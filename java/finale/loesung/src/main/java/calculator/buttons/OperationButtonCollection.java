package calculator.buttons;

import calculator.buttons.listeners.OperationButtonActionListener;
import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;
import calculator.state.CalculatorState;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class OperationButtonCollection {
    private JFrame mainFrame;
    private CalculatorState calculatorState;
    private List<JButton> operationButtons = new ArrayList<>();

    public OperationButtonCollection(CalculatorState calculatorState, JFrame mainFrame) {
        this.calculatorState = calculatorState;
        this.mainFrame = mainFrame;

        setupButtons();
    }

    public List<JButton> getButtons() {
        return operationButtons;
    }

    private void setupButtons() {
        String operationMultiplySymbol = Translator.getMessage(TranslationKeys.BUTTON_OPERATION_MULTIPLY_SYMBOL);

        String[] buttonSymbols = new String[] {
            "+", "-", operationMultiplySymbol, "/"
        };

        for (String buttonSymbol : buttonSymbols) {
            setupButtonWithSymbol(new JButton(buttonSymbol), buttonSymbol);
        }
    }

    private void setupButtonWithSymbol(JButton button, String symbol) {
        final int fontSize = 18;
        final String fontName = "";

        button.addActionListener(new OperationButtonActionListener(symbol, mainFrame, calculatorState));
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setFont(new Font(fontName, Font.PLAIN, fontSize));

        operationButtons.add(button);
    }
}
