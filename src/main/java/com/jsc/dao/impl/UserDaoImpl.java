package com.jsc.dao.impl;

import com.jsc.dao.UserDao;
import com.jsc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<User> findAllUser() {
        String sql="select * from user";
        List<User> userList = null;
        try {
            userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
        }
        return userList;
    }
}
