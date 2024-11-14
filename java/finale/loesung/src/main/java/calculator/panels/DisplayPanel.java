package calculator.panels;

// region Imports

import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;
import calculator.state.CalculatorState;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

// endregion

public class DisplayPanel extends AbstractPanel {
    private JTextField calculationField = new JTextField();
    private JTextField inputField = new JTextField();

    public DisplayPanel(JFrame mainFrame, CalculatorState calculatorState) {
        super(mainFrame, BorderLayout.NORTH, calculatorState);

        setupFields();

        registerPropertyChangeListener();
    }

    private void registerPropertyChangeListener() {
        getCalculatorState().getChangeSupport().registerForInputForegroundChange(event ->
            inputField.setForeground((Color) event.getNewValue())
        );

        getCalculatorState().getChangeSupport().registerForInputValueChange(event ->
            inputField.setText((String) event.getNewValue())
        );

        getCalculatorState().getChangeSupport().registerForCalculationResultChange(event -> {
            double result = (double) event.getNewValue();
            String resultText = result > 0 ? Double.toString(result) : "";

            calculationField.setText(resultText);
        });

        getCalculatorState().getChangeSupport().registerForInputBufferChange(event ->
            writeInputBufferToCalculationField()
        );
    }

    private void setupFields() {
        setupTotalCalculationField();
        setupInputField();
    }

    private void setupTotalCalculationField() {
        final String fontName = "";
        final int fontSize = 15;

        calculationField.setFont(new Font(fontName, Font.PLAIN, fontSize));
        calculationField.setToolTipText(Translator.getMessage(TranslationKeys.DISPLAY_CALCULATION_TOOLTIP));

        addFieldWithLayout(calculationField, BorderLayout.NORTH);
    }

    private void setupInputField() {
        inputField.setToolTipText(Translator.getMessage(TranslationKeys.DISPLAY_INPUT_TOOLTIP));

        addFieldWithLayout(inputField, BorderLayout.SOUTH);
    }

    private void addFieldWithLayout(JTextField field, String layout) {
        field.setHorizontalAlignment(SwingConstants.RIGHT);
        field.setEditable(false);

        getPanel().add(field, layout);
    }

    private void writeInputBufferToCalculationField() {
        getCalculatorState().setCalculationResult(0.0);

        List<String> inputBuffer = getCalculatorState().getInputBuffer();

        resetCalculationField(inputBuffer);

        parseBuffer(inputBuffer);
    }

    private void resetCalculationField(List<String> inputBuffer) {
        calculationField.setText("");

        if (inputBuffer.isEmpty()) {
            inputField.setText("");
        }
    }

    private void parseBuffer(List<String> inputBuffer) {
        for (int i = 0; i < inputBuffer.size(); i++) {
            String currentCalculationText = calculationField.getText();

            calculationField.setText(currentCalculationText + " " + inputBuffer.get(i));
        }
    }
}
