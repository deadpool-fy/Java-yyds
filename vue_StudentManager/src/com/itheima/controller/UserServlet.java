package com.itheima.controller;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //将获取的数据封装为一个user对象
        User user = new User(username,password);
        //调用service层的login方法
        List<User> list = service.login(user);
        //如果集合长度不为0则代表用户名密码正确
        if(list.size()!=0){
            //将username存入会话域中
            request.getSession().setAttribute("username",username);
            //给客户端相应一个true
            response.getWriter().write("true");
        }else {
            //否则相应一个false
            response.getWriter().write("false");
        }
    }
}
