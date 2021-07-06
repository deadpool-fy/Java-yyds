package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    StudentService service = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //1.获取方法名
        String method = request.getParameter("method");
        if (method.equals("selectByPage")) {
            //分页查询功能
            selectByPage(request, response);
        } else if (method.equals("addStu")) {
            addStu(request, response);
        }else if(method.equals("updateStu")){
            updateStu(request, response);
        }else if(method.equals("deleteStu")){
            deleteStu(request, response);
        }
    }

    private void deleteStu(HttpServletRequest request, HttpServletResponse response) {
        String number = request.getParameter("number");
        service.deleteStu(number);
        selectByPage(request,response);
    }

    private void updateStu(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> map = request.getParameterMap();
        Student stu = new Student();
        //注册日期转换器方法
        dateConvert();
        try {
            BeanUtils.populate(stu,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用业务层的修改方法
        service.updateStu(stu);
        selectByPage(request,response);
    }

    private void addStu(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> map = request.getParameterMap();
        Student stu = new Student();
        //注册日期转换器方法
        dateConvert();
        try {
            BeanUtils.populate(stu,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.addStu(stu);
        selectByPage(request,response);
    }
    //注册日期转换器方法
    private void dateConvert() {
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, Date.class);
    }

    private void selectByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取请求参数
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        //调用业务层的查询方法
        Page page = service.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));

        //封装PageInfo
        PageInfo info = new PageInfo(page);

        //将info转成json，响应给客户端
        try {
            String json = new ObjectMapper().writeValueAsString(info);
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
