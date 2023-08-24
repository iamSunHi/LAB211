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
public class PhoneValidator {
    private static final String PHONE_REGEX = "\\d{10}";

    public PhoneValidator() {
    }

    public static boolean validate(String phone) {
        return Pattern.matches(PHONE_REGEX, phone);
    }

    public static String getPHONE_REGEX() {
        return PHONE_REGEX;
    }
}
