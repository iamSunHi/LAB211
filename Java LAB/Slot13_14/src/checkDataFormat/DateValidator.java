/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkDataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nhật Huy
 */
public class DateValidator {
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public DateValidator() {
    }

    public static boolean validate(String date) {
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
            dateFormatter.setLenient(false);
            dateFormatter.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getDATE_FORMAT() {
        return DATE_FORMAT;
    }
}
