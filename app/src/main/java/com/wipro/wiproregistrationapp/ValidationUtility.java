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
    static boolean isEircodeValidFormat(String eircode) {
        String stringEircodeRegularExpression = "^([AC-FHKNPRTV-Y]\\d{2}|D6W)[0-9AC-FHKNPRTV-Y]{4}+$";
        return eircode.matches(stringEircodeRegularExpression);
    }
}
