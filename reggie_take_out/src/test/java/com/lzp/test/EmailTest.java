package com.lzp.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Calendar;
import java.util.Random;

/**
 * @author: LZPing
 * @date: 2022-12-14 18:29
 * @Description
 */
@SpringBootTest
public class EmailTest {
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送邮件
     *
     * @param code 验证码
     * @param from 发送验证码的邮箱
     * @param to   接收验证码的邮箱
     * @return true 发送成功，否则发送失败
     */
    public boolean sendEmailCode(String code, String from, String to) {
        try {
            // 用来设置邮件信息
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            // 设置邮件标题
            simpleMailMessage.setSubject("瑞吉外卖登录验证码");
            // 设置邮件内容
            simpleMailMessage.setText("【瑞吉外卖】您的验证码为"+code+",有效期为3分钟,请确保是本人操作,不要把验证码泄露给其他人。");
            // 设置源邮箱
            simpleMailMessage.setFrom(from);
            // 设置目的邮箱
            simpleMailMessage.setTo(to);
            // 发送
            javaMailSender.send(simpleMailMessage);
            // 没有出现异常，正常发送，返回true
            return true;
        } catch (MailException e) {
            // 发送过程中，发生错误，打印错误信息，返回false
            e.printStackTrace();
            return false;
        }
    }

    @Test
    public void test() {
        // 设置验证码，可以自己随机生成
        String code = randomCode();
        System.out.println("生成的随机验证码为:"+code);
        boolean b = sendEmailCode(code, "17683995798@163.com", "17683995798@163.com");
        if (b) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
    }

    public String randomCode() {
        StringBuilder code = new StringBuilder();
        int length = 6;
        for (int i = 0; i < length; i++) {
            code.append(new Random().nextInt(10));
        }
        return code.toString();
    }
}
