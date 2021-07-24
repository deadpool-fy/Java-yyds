package com.itheima.dao.impl;

import com.itheima.dao.ResourceDao;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceDaoImpl implements ResourceDao {
    @Override
    public boolean readResource(String url, String password) {
        return password.equals("root");
    }
}
