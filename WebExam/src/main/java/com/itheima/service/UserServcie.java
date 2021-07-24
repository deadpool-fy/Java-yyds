package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserServcie {
    void save(User user);

    List<User> findAll();

    void delete(String id);

    void update(User user);

    User findById(String id);
}
