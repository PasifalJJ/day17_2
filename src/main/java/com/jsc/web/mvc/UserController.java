package com.jsc.web.mvc;

import com.jsc.domain.User;
import com.jsc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model){
        System.out.println("this.userService = " + this.userService);
        List<User> userList = userService.findAllUser();
        System.out.println(userList);
        model.addAttribute("userList",userList);
        return "/list";
    }
}
