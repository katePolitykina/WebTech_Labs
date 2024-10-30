package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null || email.isEmpty())
            return false;
        Pattern p = Pattern.compile("[a-zA-Z]+_[a-zA-Z]+\\d*@epam.com");
        Matcher m = p.matcher(email);
        return m.matches();


    }
}





