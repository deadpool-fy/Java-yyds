package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.bean.Student;

import java.util.List;

public interface StudentService {

    /*
    分页查询方法
    */
    Page selectByPage(Integer currentPage, Integer pageSize);

    /*
    添加学生的方法
    */
    void addStu(Student stu);
    /*
     修改学生的方法
    */
    void updateStu(Student stu);
    /*
     删除学生的方法
    */
    void deleteStu(String num);
}
