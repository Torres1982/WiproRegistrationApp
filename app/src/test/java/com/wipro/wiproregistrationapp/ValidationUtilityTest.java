package com.wipro.wiproregistrationapp;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class ValidationUtilityTest {
    // ******************************** EMAIL VALIDATION *******************************************
    @Test
    public void emailValidationCorrectEmailReturnTrue() {
        assertTrue(ValidationUtility.isEmailValidFormat("torres@gmail.com"));
    }

    @Test
    public void emailValidationIncorrectDomainNameReturnFalse() {
        assertFalse(ValidationUtility.isEmailValidFormat("torres@gmail."));
    }

    @Test
    public void emailValidationIncorrectEmailUsernameReturnFalse() {
        assertFalse(ValidationUtility.isEmailValidFormat("@hotmail.com"));
    }

    @Test
    public void emailValidationIncorrectEmailEmptyStringReturnFalse() {
        assertFalse(ValidationUtility.isEmailValidFormat(""));
    }

    @Test
    public void emailValidationIncorrectEmailNoAddressSignReturnFalse() {
        assertFalse(ValidationUtility.isEmailValidFormat("torres.gmail.com"));
    }

    @Test
    public void emailValidationIncorrectEmailMultipleAddressSignsReturnFalse() {
        assertFalse(ValidationUtility.isEmailValidFormat("torres@fernando@gmail.com"));
    }

    @Test
    public void emailValidationIncorrectEmailMultipleDotCharactersReturnFalse() {
        assertFalse(ValidationUtility.isEmailValidFormat("torres@gmail...com"));
    }

    @Test(expected = NullPointerException.class)
    public void emailValidationIncorrectEmailNullValueReturnFalse() {
        assertFalse(ValidationUtility.isEmailValidFormat(null));
    }

    // ******************************** STRING VALIDATION ******************************************
    @Test
    public void stringValidationCorrectStringLowerCapitalLettersReturnTrue() {
        assertTrue(ValidationUtility.isString("Kildare"));
    }

    @Test
    public void stringValidationIncorrectStringBlankSpaceReturnFalse() {
        assertFalse(ValidationUtility.isString("Dublin North"));
    }

    @Test
    public void stringValidationIncorrectStringNumbersProvidedReturnFalse() {
        assertFalse(ValidationUtility.isString("Dublin12"));
    }

    @Test
    public void stringValidationIncorrectStringEmptyValueReturnFalse() {
        assertFalse(ValidationUtility.isString(""));
    }

    @Test
    public void stringValidationIncorrectStringNonLetterCharactersReturnFalse() {
        assertFalse(ValidationUtility.isString("_*/=+()'>"));
    }

    // ******************************** EIRCODE VALIDATION *****************************************
    @Test
    public void eircodeValidationCorrectEircodeReturnTrue() {
        assertTrue(ValidationUtility.isEircodeValidFormat("D08X2A5"));
    }
    
    @Test
    public void eircodeValidationCorrectEircodeForD6WRegionReturnTrue() {
        assertTrue(ValidationUtility.isEircodeValidFormat("D6WA5F7"));
    }
    
    @Test
    public void eircodeValidationIncorrectEircodeNonLetterOrNonDigitCharactersReturnFalse() {
        assertFalse(ValidationUtility.isEircodeValidFormat("_RE45+-/>"));
    }

    @Test
    public void eircodeValidatorIncorrectEircodeEmptyValueReturnFalse() {
        assertFalse(ValidationUtility.isEircodeValidFormat(""));
    }
    
    @Test
    public void eircodeValidationIncorrectEircodeNonAllowedLetterCharactersReturnFalse() {
        assertFalse(ValidationUtility.isEircodeValidFormat("D22G5L1"));
    }
    
    @Test
    public void eircodeValidationIncorrectEircodeNonNumericCharactersProvidedReturnFalse() {
        assertFalse(ValidationUtility.isEircodeValidFormat("ACHKPRT"));
    }
    
    @Test
    public void eircodeValidationIncorrectEircodeNonLetterCharactersProvidedReturnFalse() {
        assertFalse(ValidationUtility.isEircodeValidFormat("1745365"));
    }
    
    @Test
    public void eircodeValidationIncorrectEircodeLowerCaseLettersIncludedReturnFalse() {
        assertFalse(ValidationUtility.isEircodeValidFormat("d08x2a5"));
    }

    // ********************************** AGE VALIDATION *******************************************
    @Test
    public void ageValidationCorrectAgeOverEighteenReturnTrue() {
        // Converting Gregorian Calendar to Date with usage of getTime()
        assertTrue(ValidationUtility.isAgeOverEighteen((new GregorianCalendar(2001, 2, 27, 0, 0, 0)).getTime()));
    }

    @Test
    public void ageValidationIncorrectAgeUnderEighteenReturnFalse() {
        assertFalse(ValidationUtility.isAgeOverEighteen((new GregorianCalendar(2010, 5, 27, 0, 0, 0)).getTime()));
    }

    @Test
    public void ageValidationIncorrectAgeUnderEighteenTodayDateReturnFalse() {
        assertFalse(ValidationUtility.isAgeOverEighteen(new Date()));
    }
}
