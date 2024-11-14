package calculator.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public final class Translator {
    private static Translator instance;
    private ResourceBundle bundle;

    private Translator(Locale locale) {
        bundle = ResourceBundle.getBundle("Messages", locale);
    }

    public static void setLocale(Locale locale) {
        instance = new Translator(locale);
    }

    public static String getMessage(String message) {
        if (instance == null) {
            instance = new Translator(Locale.getDefault());
        }

        return instance.bundle.getString(message);
    }
}
