package com.cookie.dao;

import com.cookie.entity.User;

public interface UserDao {

    User checkUser (User user);

    User getUserById(int id);
}
