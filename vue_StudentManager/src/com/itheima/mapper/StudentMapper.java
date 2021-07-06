package com.itheima.mapper;

import com.itheima.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    /*
            查询全部方法
         */
    @Select("SELECT * FROM student")
    List<Student> selectAll();

    @Insert("insert into student values(#{number},#{name},#{birthday},#{address})")
    void addStu(Student stu);

    @Update("UPDATE student SET number=#{number},name=#{name},birthday=#{birthday},address=#{address} WHERE number=#{number}")
    void updateStu(Student stu);

    @Delete("delete from student where number=#{number}")
    void deleteStu(String num);
}
