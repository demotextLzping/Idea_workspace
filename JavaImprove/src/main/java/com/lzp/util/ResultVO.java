package com.lzp.util;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultVO {
    private String message;
    private boolean status;
    private int code;


}
