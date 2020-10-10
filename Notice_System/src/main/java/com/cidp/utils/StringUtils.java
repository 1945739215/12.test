package com.cidp.utils;

public class StringUtils {

    public final static boolean isNull(Object obj) {
        if (obj == null || isNull(obj.toString())){
            return true;
        }
        return false;
    }
}
