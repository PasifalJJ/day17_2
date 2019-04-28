package com.jsc.service;

import com.jsc.domain.LoginInf;
import com.jsc.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    User checkLogin(LoginInf loginInf);

    void addUser(User user);

    void deleteUser(int id);

    void deleteSlectUser(String[] checkboxs);

    User findUser(int id);

    void updateUser(User user);
}
