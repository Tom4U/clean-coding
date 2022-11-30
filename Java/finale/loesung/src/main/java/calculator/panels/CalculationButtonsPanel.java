package calculator.panels;

// region Imports

import calculator.buttons.listeners.CalculationButtonActionListener;
import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;
import calculator.state.CalculatorState;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

// endregion

public class CalculationButtonsPanel extends AbstractPanel {
    private static final ArrayList<JButton> NUMBER_BUTTONS = new ArrayList<>();

    private JButton commaButton;
    private JButton stepBackButton;

    public CalculationButtonsPanel(JFrame mainFrame, CalculatorState calculatorState) {
        super(mainFrame, BorderLayout.CENTER, calculatorState);

        setupButtons();

        calculatorState.getChangeSupport()
                .registerForCommaButtonEnabledChange(event -> commaButton.setEnabled((Boolean) event.getNewValue()));
    }

    @Override
    protected void setupPanel() {
        final int rows = 4;
        final int columns = 3;

        setPanel(new JPanel(new GridLayout(rows, columns)));
    }

    @Override
    protected void enableButtons() {
        for (JButton button : NUMBER_BUTTONS) {
            button.setEnabled(true);
        }

        commaButton.setEnabled(true);
        stepBackButton.setEnabled(true);
    }

    @Override
    protected void disableButtons() {
        for (JButton button : NUMBER_BUTTONS) {
            button.setEnabled(false);
        }

        commaButton.setEnabled(false);
        stepBackButton.setEnabled(false);
    }

    private void setupButtons() {
        setupNumberButtons();
        setupCommaButton();
    }

    private void setupNumberButtons() {
        final int firstInvalidNumber = 10;
        final int lastPossibleNumber = 9;

        for (int i = 0; i < firstInvalidNumber; i++) {
            generateNumberButton(lastPossibleNumber, i);
        }
    }

    private void generateNumberButton(final int lastPossibleNumber, int number) {
        String symbol = Integer.toString(number);
        JButton numberButton = new JButton(symbol);

        if (number == lastPossibleNumber) {
            setupStepBackButton();
        }

        NUMBER_BUTTONS.add(numberButton);

        addButtonToPanel(numberButton, symbol);
    }

    private void setupStepBackButton() {
        String symbol = Translator.getMessage(TranslationKeys.BUTTON_STEPBACK_SYMBOL);

        stepBackButton = new JButton(symbol);
        stepBackButton.setToolTipText(Translator.getMessage(TranslationKeys.BUTTON_STEPBACK_TOOLTIP));

        addButtonToPanel(stepBackButton, symbol);

    }

    private void setupCommaButton() {
        String symbol = Translator.getMessage(TranslationKeys.BUTTON_COMMA_SYMBOL);

        commaButton = new JButton(symbol);

        addButtonToPanel(commaButton, symbol);
    }

    private void addButtonToPanel(JButton button, String symbol) {
        CalculationButtonActionListener listener = new CalculationButtonActionListener(symbol, getMainFrame(),
                getCalculatorState());

        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(listener);

        getPanel().add(button);
    }
}
