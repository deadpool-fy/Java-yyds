package com.itheima.service;

import com.itheima.bean.User;

import java.util.List;

public interface UserService {
    //登录方法
    List<User> login(User user);
}
