package com.lzp.dao;


import com.lzp.model.User;

public interface UserDao {

    public User queryUserByUnameAndUpwd(User user);
}
