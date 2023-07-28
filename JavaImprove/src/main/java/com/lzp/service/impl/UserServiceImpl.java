package com.lzp.service.impl;


import com.lzp.dao.UserDao;
import com.lzp.dao.impl.UserDaoImpl;
import com.lzp.model.User;
import com.lzp.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public boolean doLogin(User user) {
        if(userDao.queryUserByUnameAndUpwd(user)!=null){
            return true;
        }else {
            return false;
        }

    }
}
