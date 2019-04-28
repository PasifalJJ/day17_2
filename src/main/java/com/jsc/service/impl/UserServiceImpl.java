package com.jsc.service.impl;

import com.jsc.dao.UserDao;
import com.jsc.domain.LoginInf;
import com.jsc.domain.User;
import com.jsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAllUser() {

        return userDao.findAllUser();
    }

    @Override
    public User checkLogin(LoginInf loginInf) {
        return userDao.checkLogin(loginInf);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void deleteSlectUser(String[] checkboxs) {
        int[] ints = new int[checkboxs.length];
        for (int i = 0; i < checkboxs.length; i++) {
            ints[i] = Integer.parseInt(checkboxs[i]);
        }
        userDao.deleteSlectUser(ints);
    }

    @Override
    public User findUser(int id) {
        User user = userDao.findUser(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
