package com.lzp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lzp.common.BaseContext;
import com.lzp.common.R;
import com.lzp.common.ValidateCodeUtils;
import com.lzp.entity.ShoppingCart;
import com.lzp.entity.User;
import com.lzp.service.ShoppingCartService;
import com.lzp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

import static com.lzp.common.SMSUtils.sendEmailCode;

/**
 * @author: LZPing
 * @date: 2022-12-15 12:36
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送验证码
     *
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            String code = ValidateCodeUtils.randomCode(6);
            log.info("生成的6位验证码为 : {}", code);
            //封装邮件
            SimpleMailMessage simpleMailMessage = sendEmailCode(code, "17683995798@163.com", "17683995798@163.com");
            //发送邮件
            javaMailSender.send(simpleMailMessage);
            session.setAttribute(code, code);

            return R.success("验证码邮件发送成功！！！");
        }
        return R.success("验证码邮件发送失败！！！");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        log.info(map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();
        //从session中获取保存的验证码
        Object codeInSession = session.getAttribute(code);
        if (codeInSession != null && codeInSession.equals(code)) {
            //弱国比对成功,则说明登录成功
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(userLambdaQueryWrapper);
            if (user == null) {
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());
            return R.success(user);
        }
        return R.error("登录失败！！");
    }
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        //清理Session中保存的当前的员工的id
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }



}
