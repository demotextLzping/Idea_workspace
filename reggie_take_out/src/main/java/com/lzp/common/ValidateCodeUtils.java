package com.lzp.common;

import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * @author: LZPing
 * @date: 2022-12-15 12:33
 * @Description
 */
@Component
public class ValidateCodeUtils {


    public static String randomCode(Integer len) {
        StringBuilder code = new StringBuilder();
        int length = len;
        for (int i = 0; i < length; i++) {
            code.append(new Random().nextInt(10));
        }
        return code.toString();
    }
}
