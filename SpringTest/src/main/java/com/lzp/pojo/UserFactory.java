package com.lzp.pojo;

import org.springframework.beans.factory.FactoryBean;


public class UserFactory implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setId(10086);
        user.setName("移动");
        user.setAge(29);
        user.setSex("女");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
