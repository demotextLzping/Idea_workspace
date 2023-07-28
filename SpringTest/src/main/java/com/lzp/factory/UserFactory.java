package com.lzp.factory;

import com.lzp.pojo.User;

public class UserFactory {
    public User getInstance() {
        return new User(112, "王五", 24, "男");
    }
//
//    public static User getInstance() {
//        return new User(112, "王五static", 24, "男");
//    }


//    public User getInstance(User user) {
//        return user;
//    }

    public static User getInstance(User user) {
        return user;
    }


}
