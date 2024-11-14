package calculator.buttons.listeners;

import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;
import calculator.state.CalculatorState;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class CalculationButtonActionListener extends AbstractButtonActionListener {
    private final String commaSymbol = Translator.getMessage(TranslationKeys.BUTTON_COMMA_SYMBOL);
    private final String stepBackSymbol = Translator.getMessage(TranslationKeys.BUTTON_STEPBACK_SYMBOL);

    public CalculationButtonActionListener(String symbol, JFrame mainFrame, CalculatorState calculatorState) {
        super(symbol, mainFrame, calculatorState);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();

        if (Boolean.TRUE.equals(isNumber(command))) {
            performOperationForNumber(command);
        }

        performOperationForSymbol(actionEvent.getActionCommand());
    }

    private Boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    // region Operations

    private void performOperationForNumber(String number) {
        getCalculatorState().addInputValue(number);
    }

    private void performOperationForSymbol(String operationSymbol) {
        if (operationSymbol.equals(commaSymbol)) {
            performOperationForComma();
        }

        if (operationSymbol.equals(stepBackSymbol)) {
            performOperationForStepBack();
        }
    }

    private void performOperationForComma() {
        getCalculatorState().addInputValue(commaSymbol);
        getCalculatorState().setCommaButtonEnabled(false);
    }

    private void performOperationForStepBack() {
        try {
            String newInputValue = readNewInputValue();

            getCalculatorState().setInputValue(newInputValue);
        } catch (StringIndexOutOfBoundsException exception) {
            stepBackWithoutExisitingNumber();
        }
    }

    // endregion

    // region Stepback Operation Helpers

    private String readNewInputValue() {
        ArrayList<Character> characters = readCharactersFromInputExceptLast();

        Iterator<Character> charactersIterator = characters.iterator();
        StringBuilder newInputValueBuilder = new StringBuilder();

        while (charactersIterator.hasNext()) {
            newInputValueBuilder.append(charactersIterator.next());
        }

        return newInputValueBuilder.toString();
    }

    private ArrayList<Character> readCharactersFromInputExceptLast() {
        String inputValue = getCalculatorState().getInputValue();
        int lastCharacterIndex = inputValue.length() - 1;
        char lastCharacter = inputValue.charAt(lastCharacterIndex);

        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < lastCharacterIndex; i++) {
            characters.add(inputValue.charAt(i));
        }

        checkIfCharacterIsComma(lastCharacter);

        return characters;
    }

    private void checkIfCharacterIsComma(char character) {
        getCalculatorState().setCommaButtonEnabled(Character.toString(character).equals(commaSymbol));
    }

    private void stepBackWithoutExisitingNumber() {
        showError();
    }

    // endregion
}
