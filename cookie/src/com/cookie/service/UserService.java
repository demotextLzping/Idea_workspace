package com.cookie.service;

import com.cookie.entity.User;

public interface UserService {
    User checkUser (User user);

    User getUserById(int id);
}
