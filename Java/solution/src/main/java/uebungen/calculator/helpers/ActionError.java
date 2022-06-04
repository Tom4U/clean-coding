package uebungen.calculator.helpers;

import uebungen.calculator.i18n.TranslationKeys;
import uebungen.calculator.i18n.Translator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;

public final class ActionError {
    private ActionError() {}

    public static void showError(JFrame frame) {
        String title = Translator.getMessage(TranslationKeys.ERROR_NONUMBER_TITLE);
        String message = Translator.getMessage(TranslationKeys.ERROR_NONUMBER_MESSAGE);

        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(frame, message, title, 0);
    }
}
