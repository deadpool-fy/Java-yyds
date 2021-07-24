package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    /*添加*/
    @Insert("insert into user (username,email) values(#{username},#{email})")
    int save(User user);

    /*删除*/
    @Delete("delete from user where id=#{id}")
    int delete(String id);

    /*修改*/
    @Update("UPDATE user SET id=#{id},username=#{username},email=#{email} WHERE id=#{id}")
    int update(User user);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(String id);
}
