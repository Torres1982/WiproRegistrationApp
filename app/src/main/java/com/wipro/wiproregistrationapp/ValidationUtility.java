package com.wipro.wiproregistrationapp;

import java.util.regex.Pattern;

public class ValidationUtility {
    // Email format validation
    public static boolean isEmailValidFormat(String email) {
        final Pattern EMAIL_PATTERN;
        EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // String format validation
    public static boolean isString(String string) {
        String stringRegularExpression = "^[a-zA-Z]+$";
        return string.matches(stringRegularExpression);
    }

    // Eircode format validation (simple)
    public static boolean isEircodeValidFormat(String eircode) {
        String stringEircodeRegularExpression = "^[a-zA-Z0-9]+$";
        return eircode.matches(stringEircodeRegularExpression);
    }
}
