package com.magic.util;

public class Stringutil {

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
        return  true;
        }
        return false;
    }
}
