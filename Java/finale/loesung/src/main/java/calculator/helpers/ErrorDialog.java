package calculator.helpers;

import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;

public final class ErrorDialog {
    private ErrorDialog() {}

    public static void showNoNumberError(JFrame frame) {
        String title = Translator.getMessage(TranslationKeys.ERROR_NONUMBER_TITLE);
        String message = Translator.getMessage(TranslationKeys.ERROR_NONUMBER_MESSAGE);

        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(frame, message, title, 0);
    }
}
