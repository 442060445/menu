package com.longxingyang.utils;

import java.util.Random;

/**
 * Created by a4420 on 17/12/07.
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
