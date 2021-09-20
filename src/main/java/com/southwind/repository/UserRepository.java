package com.southwind.repository;

import com.southwind.entity.User;

import java.util.List;

public interface UserRepository {
    public void deleteById(Long id);
    public List<User> findAll();
    public User findById(Long id);
    public void save(User user);
    public void update(User user);
}
