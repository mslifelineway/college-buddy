package com.codinghub.collegebuddy.utils;

public class StringUtils {

	public static String toCommaSeperatedString(Object[] items) {
        StringBuilder sb = new StringBuilder();

        for (Object item : items) {
            sb.append(item).append(",");
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
