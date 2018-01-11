package com.longxingyang.utils;

import com.longxingyang.enums.CodeEnum;

/**
 * Created by a4420 on 18/01/10.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}