package com.wipro.wiproregistrationapp;

import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class DateTimeUtility {
    // Converting String to Date
    static Date convertStringToDate(int day, int month, int year) {
        Date selectedDate = null;

        try {
            String dateString = day + "-" + month + "-" + year;
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            selectedDate = df.parse(dateString);
        } catch (Exception e) {
            Log.i("DATE_PARSE_EXCEPTION_TAG", "**************** Exception Date Parser *****************");
        }
        return selectedDate;
    }
}
