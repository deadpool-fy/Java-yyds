package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


public class StudentServiceImpl implements StudentService {

    @Override
    public Page selectByPage(Integer currentPage, Integer pageSize) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //4.获取StudentMapper接口实现类对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //5.设置分页参数
        Page page = PageHelper.startPage(currentPage, pageSize);
        //6.调用实现类对象查询全部方法
        mapper.selectAll();
        //6.调用实现类对象查询全部方法
        sqlSession.close();
        return page;
    }

    @Override
    public void addStu(Student stu) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //4.获取StudentMapper接口实现类对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.addStu(stu);
        sqlSession.close();
    }

    @Override
    public void updateStu(Student stu) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //4.获取StudentMapper接口实现类对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //5.调用实现类对象修改方法
        mapper.updateStu(stu);
        sqlSession.close();
    }

    @Override
    public void deleteStu(String num) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //4.获取StudentMapper接口实现类对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStu(num);
        sqlSession.close();
    }
}
