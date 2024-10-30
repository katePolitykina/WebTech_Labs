package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null || color.isEmpty())
            return false;
        Pattern p = Pattern.compile("#(\\d|[a-f]|[A-F]){6}|#(\\d|[a-f]|[A-F]){3}");
        Matcher m = p.matcher(color);
        return m.matches();
    }
}





