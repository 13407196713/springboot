package com.southwind.repository.impl;

import com.southwind.entity.User;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from user where id = ?",id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("select * from user where id = ?",new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user(id,name,score) values(?,?,?)",user.getId(), user.getName(),user.getScore());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("update user set name = ?,score = ? where id = ?",user.getName(),user.getScore(),user.getId());
    }
}
