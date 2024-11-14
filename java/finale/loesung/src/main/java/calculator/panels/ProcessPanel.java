package calculator.panels;

import calculator.buttons.listeners.ProcessButtonActionListener;
import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;
import calculator.state.CalculatorState;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

// endregion

public class ProcessPanel extends AbstractPanel {
    private JButton calculateButton;

    public ProcessPanel(JFrame frame, CalculatorState calculatorState) {
        super(frame, BorderLayout.SOUTH, calculatorState);

        calculatorState.getChangeSupport()
                .registerForAllButtonsEnabledChange(event -> calculateButton.setEnabled((Boolean) event.getNewValue()));
    }

    @Override
    protected void runAfterPanelSetup() {
        setupResetButton();
        setupCalculateButton();
    }

    private void setupResetButton() {
        String title = Translator.getMessage(TranslationKeys.BUTTON_RESET_TITLE);
        String tooltip = Translator.getMessage(TranslationKeys.BUTTON_RESET_TOOLTIP);

        JButton resetButton = new JButton(title);

        addButtonToPanel(resetButton, title, tooltip, BorderLayout.WEST);
    }

    private void setupCalculateButton() {
        String symbol = Translator.getMessage(TranslationKeys.BUTTON_CALCULATE_SYMBOL);
        String tooltip = Translator.getMessage(TranslationKeys.BUTTON_CALCULATE_TOOLTIP);
        final int fontSize = 18;
        final String fontName = "";

        calculateButton = new JButton(symbol);
        calculateButton.setFont(new Font(fontName, Font.PLAIN, fontSize));

        addButtonToPanel(calculateButton, symbol, tooltip, BorderLayout.CENTER);
    }

    private void addButtonToPanel(JButton button, String symbol, String toolTip, String borderLayout) {
        configureCommonButton(symbol, toolTip, button);

        getPanel().add(button, borderLayout);
    }

    private void configureCommonButton(String symbol, String toolTip, JButton button) {
        button.setBackground(Color.BLACK);

        button.setForeground(Color.WHITE);

        button.setToolTipText(toolTip);

        button.addActionListener(new ProcessButtonActionListener(symbol, getMainFrame(), getCalculatorState()));
    }
}
