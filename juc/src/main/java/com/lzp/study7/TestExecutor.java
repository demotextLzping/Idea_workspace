package com.lzp.study7;

import java.util.concurrent.Executor;

/**
 * @author: LZPing
 * @date: 2023-02-19 09:19
 * @Description
 */

public class TestExecutor {
    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        };
    }
}
