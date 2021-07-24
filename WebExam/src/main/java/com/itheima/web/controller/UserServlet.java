package com.itheima.web.controller;

import com.itheima.domain.User;
import com.itheima.service.UserServcie;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.util.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    public UserServcie userServcie = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("findAll".equals(method)) {
            findAll(request, response);
        } else if ("toAdd".equals(method)) {
            toAdd(request, response);
        } else if ("addUser".equals(method)) {
            addUser(request, response);
        } else if ("delete".equals(method)) {
            delete(request, response);
        } else if ("toUpdate".equals(method)) {
            toUpdate(request, response);
        } else if ("update".equals(method)) {
            update(request, response);
        }
    }

    private void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = userServcie.findById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/pages/User_Update.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = BeanUtil.fillBean(request, User.class);
        userServcie.update(user);
        response.sendRedirect(request.getContextPath() + "/user?method=findAll");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        userServcie.delete(id);
        response.sendRedirect(request.getContextPath() + "/user?method=findAll");
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //将数据获取到，封装成一个对象
        User user = BeanUtil.fillBean(request, User.class);
        //调用业务层接口save
        userServcie.save(user);

        //跳转回到页面list
        response.sendRedirect(request.getContextPath() + "/user?method=findAll");
    }

    private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/User_Add.jsp").forward(request, response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userServcie.findAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/pages/User_List.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
