package calculator.buttons.listeners;

// region Imports

import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;
import calculator.state.CalculatorState;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

// endregion

public class ProcessButtonActionListener extends OperationButtonActionListener {
    public ProcessButtonActionListener(String symbol, JFrame mainFrame, CalculatorState calculatorState) {
        super(symbol, mainFrame, calculatorState);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String symbol = getSymbol();
        String resetTitle = Translator.getMessage(TranslationKeys.BUTTON_RESET_TITLE);
        if (symbol.equals(resetTitle)) {
            performResetOperation();
        } else {
            performCalculateOperation();
        }
    }

    // region Operations

    private void performResetOperation() {
        getCalculatorState().setInputValue("");

        getCalculatorState().setInputForeground(Color.BLACK);

        getCalculatorState().setCalculationResult(0.0);

        resetBuffer();

        getCalculatorState().setAllButtonsEnabled(true);
    }

    private void performCalculateOperation() {
        try {
            checkInvalidInput();

            prepareButtonsAndDisplays();

            printResult();

        } catch (NumberFormatException exception) {
            showError();
        }
    }

    // endregion

    private void resetBuffer() {
        List<String> buffer = new ArrayList<>(getCalculatorState().getInputBuffer());

        buffer.clear();

        getCalculatorState().setInputBuffer(buffer);
    }

    // region Calculate Operation Helper Methods

    private void prepareButtonsAndDisplays() {
        getCalculatorState().setAllButtonsEnabled(false);

        getCalculatorState().setInputForeground(Color.RED);
    }

    private void printResult() {
        double calculationResult = calculateResult();
        int resultAsInteger = (int) calculationResult;
        Boolean isInteger = resultAsInteger == calculationResult;

        if (Boolean.TRUE.equals(isInteger)) {
            printResultWithoutComma(resultAsInteger);
        } else {
            printResultWithComma(calculationResult);
        }
    }

    private double calculateResult() {
        getCalculatorState().addLastInputToInputBuffer();

        List<String> buffer = getCalculatorState().getInputBuffer();
        double result = getCalculatorState().getFirstNumberFromBuffer();

        result = parseBuffer(buffer, result);

        return result;
    }

    private double parseBuffer(List<String> buffer, double currentResult) {
        double result = currentResult;

        for (int i = 0; i < buffer.size(); i++) {
            int nextIndex = i + 1;

            if (nextIndex == buffer.size()) {
                break;
            }

            String possibleSymbol = buffer.get(i);
            String possibleNumber = buffer.get(nextIndex);

            result = calculateNextResult(result, possibleSymbol, possibleNumber);
        }

        return result;
    }

    private double calculateNextResult(double currentResult, String operationSymbol, String value) {
        double convertedValue = convertStringToDouble(value);
        double newResult = currentResult;

        if ("+".equals(operationSymbol)) {
            newResult = currentResult + convertedValue;
        }

        if ("-".equals(operationSymbol)) {
            newResult = currentResult - convertedValue;
        }

        if ("*".equals(operationSymbol)) {
            newResult = currentResult * convertedValue;
        }

        if ("/".equals(operationSymbol) && convertedValue > 0) {
            newResult = currentResult / convertedValue;
        }

        return newResult;
    }

    private double convertStringToDouble(String value) {
        String newValue = value;

        try {
            String commaSymbol = Translator.getMessage(TranslationKeys.BUTTON_COMMA_SYMBOL);

            if (value.contains(commaSymbol)) {
                newValue = value.replaceAll(commaSymbol, ".");
            }

            return Double.parseDouble(newValue);
        } catch (NumberFormatException exception) {
            return 0;
        }
    }

    private void printResultWithComma(double result) {
        getCalculatorState().setInputValue(Double.toString(result));
    }

    private void printResultWithoutComma(int result) {
        getCalculatorState().setInputValue(Integer.toString(result));
    }

    // endregion

}
