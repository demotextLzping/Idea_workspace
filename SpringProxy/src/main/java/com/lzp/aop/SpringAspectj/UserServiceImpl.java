package com.lzp.aop.SpringAspectj;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//规则 @Service 注解：如果没有明确设置id值，那么默认的id值是 类名首字母小写
//@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public void add() throws Exception {
        System.out.println("添加User成功");
    }

    @Override
    public void delete() throws Exception {
        System.out.println("删除User成功");
    }
}
