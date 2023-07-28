package com.lzp.test7.test2;

import java.util.Scanner;

/**
 * @author: LZPing
 * @date: 2023-01-03 16:09
 * @Description
 */

public class rule {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("用户名：必须是大小写字母、数字和_的组合，长度为3到16个字符。");
            String name = scanner.next();
            boolean nameMatches = name.matches("^(?![A-Za-z0-9]+$)(?![a-z0-9_]+$)(?![A-Za-z_]+$)(?![A-Z0-9_]+$)[a-zA-Z0-9_]{3,}$");
            System.out.println(nameMatches);
            System.out.println("密码：开头必须是大小写字母或者数字，后面加1个或者多个“.”，然后再加一个或者多个大小写字母或数字。");
            String password = scanner.next();
            boolean passwordMatches = password.matches("(^[0-9]+|^[a-zA-Z]+)(\\.+)([0-9]+$|[a-zA-Z]+$)");
            System.out.println(passwordMatches);
            System.out.println("邮箱：@前面可以是数字，字母或下划线。@后面是字母和“.”，如talta@sina.com.cn。");
            String email = scanner.next();
            boolean emailMatches = email.matches("^(\\w+)@([.A-Za-z]+)");
            System.out.println(emailMatches);

            if (nameMatches == passwordMatches == emailMatches) {
                System.out.println("验证成功");
                break;
            } else {
                System.out.println("验证失败");
            }
        }
    }
}
