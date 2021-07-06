package com.itheima.mapper;

import com.itheima.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //登陆方法
    @Select("select * from user where username=#{username} and password=#{password}")
    List<User> login(User user);
}
