package com.jsc.web.servlet;

import com.jsc.domain.User;
import com.jsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {
    @Autowired
    private  UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this.userService = " + this.userService);
        resp.setContentType("text/html;charset=utf-8");
        List<User> userList = userService.findAllUser();
        System.out.println(userList);
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
