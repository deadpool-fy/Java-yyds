package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;

public interface LogDao {
    @Insert("insert into log value(#{info},now())")
    void log(String info);
}
