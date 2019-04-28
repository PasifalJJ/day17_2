package com.jsc.dao.impl;

import com.jsc.dao.UserDao;
import com.jsc.domain.LoginInf;
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
        String sql = "select * from user";
        List<User> userList = null;
        try {
            userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
        }
        return userList;
    }

    @Override
    public User checkLogin(LoginInf loginInf) {
        String sql = "select * from user where name= ? and password = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginInf.getName(), loginInf.getPassword());
        } catch (DataAccessException e) {

        }
        return user;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user (name,gender,age,address,qq,email) values (?,?,?,?,?,?)";
        System.out.println(user);
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq()
                , user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public void deleteSlectUser(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            deleteUser(ints[i]);
        }
    }

    @Override
    public User findUser(int id) {
        String sql = "select * from user where id = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        } catch (DataAccessException e) {

        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        System.out.println(user);
        String sql="update user set gender = ? , age = ? , address = ? , qq = ? , email = ? where id = ?";
        template.update(sql,user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }
}
