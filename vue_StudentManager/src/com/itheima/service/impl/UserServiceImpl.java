package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {
    /*
        登陆方法
    */
    @Override
    public List<User> login(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.login(user);
        sqlSession.close();
        return list;
    }
}
