package com.jsc.dao;

import com.jsc.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUser();
}
