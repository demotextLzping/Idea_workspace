package com.lzp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author: LZPing
 * @date: 2022-12-15 12:38
 * @Description
 */
@Component
public class SMSUtils {
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

    public  static SimpleMailMessage sendEmailCode(String code, String from, String to) {
        // 用来设置邮件信息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置邮件标题
        simpleMailMessage.setSubject("瑞吉外卖登录验证码");
        // 设置邮件内容
        simpleMailMessage.setText("【瑞吉外卖】您的验证码为" + code + ",有效期为3分钟,请确保是本人操作,不要把验证码泄露给其他人。");
        // 设置源邮箱
        simpleMailMessage.setFrom(from);
        // 设置目的邮箱
        simpleMailMessage.setTo(to);
        // 返回封装好的邮件对象
        return simpleMailMessage;
    }
}
