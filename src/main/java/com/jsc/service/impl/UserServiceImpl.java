package com.jsc.service.impl;

import com.jsc.dao.UserDao;
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
}
