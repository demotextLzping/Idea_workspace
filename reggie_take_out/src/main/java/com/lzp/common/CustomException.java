package com.lzp.common;

/**
 * @author: LZPing
 * @date: 2022-12-11 18:07
 * @Description
 */

public class CustomException extends  RuntimeException{
    public CustomException(String message){
        super(message);
    }

}
