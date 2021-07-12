package com.itheima.service.impl;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生的业务层实现类
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAll() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        ArrayList<Student> list = mapper.findAll();
        sqlSession.close();
        return list;
    }

    @Override
    public Student findById(Integer sid) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.findById(sid);
        sqlSession.close();
        return student;
    }

    @Override
    public void save(Student student) {
        //保存
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        mapper.insert(student);
        sqlSession.close();
    }

    @Override
    public void update(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        mapper.update(student);
        sqlSession.close();
    }

    @Override
    public void delete(Integer sid) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        mapper.delete(sid);
        sqlSession.close();
    }
}
