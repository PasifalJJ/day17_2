package com.jsc.web.mvc;

import com.jsc.domain.LoginInf;
import com.jsc.domain.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface UserControl {

    public String findAllUser(Model model);

    public String checkLogin(HttpServletRequest request, LoginInf lf, Model model);

    String addUser(User user, Model model);

    String deleteUser(int id);

    String deleteSlectUser(HttpServletRequest request);

    String updateShow(int id,Model model);

    String updateUser(User user);
}
