package com.mimaraslan.util;

public class Utility {

    public static boolean isNull(String message) {
        if (message == null || message.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(String message) {
        return !isNull(message);
    }
}
