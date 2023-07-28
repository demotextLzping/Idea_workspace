package com.lzp.contraller;

import com.jfinal.core.Controller;
import com.lzp.model.User;
import com.lzp.service.UserService;
import com.lzp.service.impl.UserServiceImpl;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.lzp.util.ResultVO;

public class IndexController extends Controller {
    private final UserService userService = new UserServiceImpl();

    public void index() {
        render("/login.html");

    }

    public void doLogin() {
        User bean = getBean(User.class);
        Digester digester = new Digester(DigestAlgorithm.MD5);
        String s = digester.digestHex(bean.getUpwd());
        bean.setUpwd(s);
        boolean flag = userService.doLogin(bean);
        if (flag) {
            ResultVO resultvo = new ResultVO("用户校验成功", true, 200);
            renderJson(resultvo);
        } else {
            ResultVO resultVO = new ResultVO("用户或者密码错误,请重新登录", false, 401);
            renderJson(resultVO);
        }


    }
}