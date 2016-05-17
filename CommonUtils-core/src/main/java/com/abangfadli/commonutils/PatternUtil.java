package com.abangfadli.commonutils;

import java.util.regex.Pattern;

public class PatternUtil {
    public static Pattern emailPattern() {
        return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    }

    public static Pattern requiredPattern() {
        return Pattern.compile("^(?=\\s*\\S).*$");
    }
}
