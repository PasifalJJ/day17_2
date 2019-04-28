package com.jsc.web.mvc.impl;

import com.jsc.domain.LoginInf;
import com.jsc.domain.User;
import com.jsc.service.UserService;
import com.jsc.web.mvc.UserControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;


@RequestMapping("/user")
@Controller
public class UserControllerImpl implements UserControl {
    @Autowired
    private UserService userService;

    @RequestMapping("/findLogin")
    public String findLogin(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && !user.equals("")) {
            return findAllUser(model);
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model) {
        List<User> userList = userService.findAllUser();
        model.addAttribute("userList", userList);
        return "/list";
    }

    @RequestMapping("/checkLogin")
    @Override
    public String checkLogin(HttpServletRequest request, LoginInf loginInf, Model model) {
        HttpSession session = request.getSession();
        String _checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        //判断验证码是否正确
        String checkCode = loginInf.getCheckCode();
        if (checkCode != null && checkCode.equalsIgnoreCase(_checkCode)) {
            //判断账户密码是否正确
            String name = loginInf.getName();
            String password = loginInf.getPassword();
            User user = userService.checkLogin(loginInf);
            if (user != null && !user.equals("")) {
                session.setAttribute("user", user);
                return "redirect:/user/findAllUser";
            } else {
                model.addAttribute("error", "账号或密码错误");
            }
        } else {
            model.addAttribute("error", "验证码错误");
        }
        return "/login";
    }

    @RequestMapping("/addUser")
    @Override
    public String addUser(User user, Model model) {
        userService.addUser(user);
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/deleteUser/{id}")
    @Override
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/deleteSlectUser")
    @Override
    public String deleteSlectUser(HttpServletRequest request) {
        String[] checkboxes = request.getParameterValues("checkbox");
        userService.deleteSlectUser(checkboxes);
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/updateShow/{id}")
    @Override
    public String updateShow(@PathVariable("id") int id,Model model) {
       User user = userService.findUser(id);
       model.addAttribute("user",user);
       return "/update";
    }

    @RequestMapping("/updateUser")
    @Override
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/findAllUser";
    }
}
