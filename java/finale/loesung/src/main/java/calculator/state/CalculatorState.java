package calculator.state;

import calculator.helpers.NumberStringSanitizer;
import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CalculatorState {
    private String inputValue = "";
    private List<String> inputBuffer = new ArrayList<>();
    private Boolean allButtonsEnabled = true;
    private Boolean commaButtonEnabled = true;
    private double calculationResult;
    private Color inputForeground = Color.BLACK;

    private final CalculatorStateChangeSupport changeSupport;

    public CalculatorState() {
        changeSupport = new CalculatorStateChangeSupport(this);
    }

    public void addInputValue(String value) {
        String oldValue = inputValue;

        setInputValue(oldValue + value);
    }

    public void addOperationSymbolToInputBuffer(String symbol) {
        List<String> newBuffer = new ArrayList<>(inputBuffer);

        newBuffer.add(getInputWithoutLeadingZero());
        newBuffer.add(symbol);

        setInputBuffer(newBuffer);

        setInputValue("");

        setCommaButtonEnabled(true);
    }

    public void addLastInputToInputBuffer() {
        List<String> newBuffer = new ArrayList<>(inputBuffer);

        newBuffer.add(getInputWithoutLeadingZero());

        setInputBuffer(newBuffer);
    }

    public String getInputWithoutLeadingZero() {
        return NumberStringSanitizer.sanitizeLeadingZeros(inputValue);
    }

    public double getFirstNumberFromBuffer() {
        String commaSymbol = Translator.getMessage(TranslationKeys.BUTTON_COMMA_SYMBOL);

        return Double.parseDouble(inputBuffer.get(0).replace(commaSymbol, "."));
    }

    // region Getter/Setter

    public CalculatorStateChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String value) {
        String oldValue = inputValue;
        inputValue = value;

        getChangeSupport().fireInputValueChange(oldValue, inputValue);
    }

    public List<String> getInputBuffer() {
        return inputBuffer;
    }

    public void setInputBuffer(List<String> buffer) {
        List<String> oldBuffer = new ArrayList<>(inputBuffer);
        inputBuffer = buffer;

        getChangeSupport().fireInputBufferChange(oldBuffer, inputBuffer);
    }

    public Boolean getAllButtonsEnabled() {
        return allButtonsEnabled;
    }

    public void setAllButtonsEnabled(Boolean enabled) {
        Boolean oldState = allButtonsEnabled;
        allButtonsEnabled = enabled;

        getChangeSupport().fireAllButtonsEnabledChange(oldState, allButtonsEnabled);
    }

    public Boolean getCommaButtonEnabled() {
        return commaButtonEnabled;
    }

    public void setCommaButtonEnabled(Boolean enabled) {
        Boolean oldState = commaButtonEnabled;
        commaButtonEnabled = enabled;

        getChangeSupport().fireInputBufferChange(oldState, commaButtonEnabled);
    }

    public void setCalculationResult(double result) {
        double oldResult = calculationResult;

        calculationResult = result;

        getChangeSupport().fireCalculationResultChange(oldResult, calculationResult);
    }

    public void setInputForeground(Color color) {
        Color oldColor = inputForeground;

        inputForeground = color;

        getChangeSupport().fireInputForegroundChange(oldColor, inputForeground);
    }

    // endregion
}
