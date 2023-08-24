/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkDataFormat;

import java.util.regex.Pattern;

/**
 *
 * @author Nhật Huy
 */
public class EmailValidator {
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";

    public EmailValidator() {
    }
    
    public static boolean validate(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static String getEMAIL_REGEX() {
        return EMAIL_REGEX;
    }
}
