package calculator.buttons.listeners;

import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;
import calculator.state.CalculatorState;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;

public class OperationButtonActionListener extends AbstractButtonActionListener {
    private final String commaSymbol = Translator.getMessage(TranslationKeys.BUTTON_COMMA_SYMBOL);
    private final String multiplySymbol = Translator.getMessage(TranslationKeys.BUTTON_OPERATION_MULTIPLY_SYMBOL);

    public OperationButtonActionListener(String symbol, JFrame mainFrame, CalculatorState calculatorState) {
        super(symbol, mainFrame, calculatorState);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String symbol = getSymbol();
        String inputValue = getCalculatorState().getInputValue();

        if ("-".equals(symbol) && inputValue.isBlank()) {
            getCalculatorState().setInputValue("-");

            return;
        }

        try {
            checkInvalidInput();

            performOperationForSymbol(actionEvent.getActionCommand());
        } catch (NumberFormatException exception) {
            showError();
        }
    }

    protected void checkInvalidInput() throws NumberFormatException {
        String inputValue = getCalculatorState().getInputValue();

        Boolean inputIsInvalid = inputValue.isBlank()
                || inputValue.equals(commaSymbol)
                || "-".equals(inputValue)
                || ("-" + commaSymbol).equals(inputValue);

        if (Boolean.TRUE.equals(inputIsInvalid)) {
            throw new NumberFormatException();
        }
    }

    private void performOperationForSymbol(String operationSymbol) {
        String symbol = getSymbol();
        String validOperationSymbol;

        validOperationSymbol = symbol.equals(multiplySymbol) ? "*" : operationSymbol;

        if (validOperationSymbol.equals(symbol)) {
            getCalculatorState().addOperationSymbolToInputBuffer(validOperationSymbol);
        }
    }
}
