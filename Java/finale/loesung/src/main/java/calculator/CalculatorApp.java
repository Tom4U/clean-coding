package calculator;

import calculator.helpers.Logger;
import calculator.i18n.TranslationKeys;
import calculator.i18n.Translator;

import javax.swing.WindowConstants;

public final class CalculatorApp {
    private CalculatorApp() {}

    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();

            configureFrame(calculator);

            assureFrameIsCenteredOnScreen(calculator);

            calculator.setVisible(true);
        } catch (OutOfMemoryError error) {
            printDefaultErrorMessage();
            printCustomErrorMessage(error);
        } catch (ExceptionInInitializerError error) {
            printDefaultErrorMessage();
            printCustomErrorMessage(error);
        }
    }

    private static void assureFrameIsCenteredOnScreen(Calculator calculator) {
        calculator.setLocationRelativeTo(null);
    }

    private static void configureFrame(Calculator calculator) {
        final int width = 245;
        final int height = 360;

        calculator.setTitle(Translator.getMessage(TranslationKeys.APP_TITLE));
        calculator.setResizable(false);
        calculator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calculator.setSize(width, height);
    }

    private static void printDefaultErrorMessage() {
        Logger.write(Translator.getMessage(TranslationKeys.ERROR_DEFAULT));
    }

    private static void printCustomErrorMessage(Error error) {
        String messageTitle = Translator.getMessage(Translator.getMessage(TranslationKeys.ERROR_MESSAGE));
        String message = messageTitle + ": " + error.getMessage();

        Logger.write(message);
    }
}
