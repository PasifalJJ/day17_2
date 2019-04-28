package com.jsc.dao;

import com.jsc.domain.LoginInf;
import com.jsc.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUser();

    User checkLogin(LoginInf loginInf);

    void addUser(User user);

    void deleteUser(int id);

    void deleteSlectUser(int[] ints);

    User findUser(int id);

    void updateUser(User user);
}
