package calculator.helpers;

public final class NumberStringSanitizer {
    private NumberStringSanitizer() {}

    public static String sanitizeLeadingZeros(String value) {
        boolean needsSanitizing = true;
        String sanitizedValue = value;

        while (needsSanitizing) {
            if (containsPeriodAfterLeadingZero(sanitizedValue)) {
                sanitizedValue = removeLeadingCharacter(sanitizedValue);
            }

            if (startsWithPeriod(sanitizedValue)) {
                sanitizedValue = addLeadingZero(sanitizedValue);
            }

            if (endsWithPeriod(sanitizedValue)) {
                sanitizedValue = addTrailingZero(sanitizedValue);
            }

            if (startsWithMinusFollowedByPeriod(sanitizedValue)) {
                sanitizedValue = addZeroBetweenMinusAndPeriod(sanitizedValue);
            }

            needsSanitizing = false;
        }

        return sanitizedValue;
    }

    private static String removeLeadingCharacter(String inputValue) {
        return inputValue.substring(1);
    }

    private static String addLeadingZero(String inputValue) {
        return "0" + inputValue;
    }

    private static String addTrailingZero(String inputValue) {
        return inputValue + "0";
    }

    private static String addZeroBetweenMinusAndPeriod(String inputValue) {
        String partAfterComma = inputValue.substring(2);
        return "-0." + partAfterComma;
    }

    private static boolean containsPeriodAfterLeadingZero(String inputValue) {
        Boolean hasMoreThanOneCharacter = inputValue.length() > 1;

        if (Boolean.FALSE.equals(hasMoreThanOneCharacter)) {
            return false;
        }

        Boolean firstCharacterIsZero = inputValue.substring(0, 1).equals("0");
        Boolean secondCharacterIsNotPeriod = !inputValue.substring(1, 2).equals(".");

        return firstCharacterIsZero && secondCharacterIsNotPeriod;
    }

    private static boolean startsWithPeriod(String inputValue) {
        return inputValue.substring(0, 1).equals(".");
    }

    private static boolean endsWithPeriod(String inputValue) {
        int inputLength = inputValue.length();

        return inputValue.substring(inputLength - 1, inputLength).equals(".");
    }

    private static boolean startsWithMinusFollowedByPeriod(String inputValue) {
        String firstCharacter = inputValue.substring(0, 1);
        String secondCharacter = inputValue.substring(1, 2);

        return "-".equals(firstCharacter) && ".".equals(secondCharacter);
    }

}
