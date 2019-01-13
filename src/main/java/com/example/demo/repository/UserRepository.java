package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User, Long> {

    User findByName(String name);

    List<User> findUserByName(String name);

    User findUserByUsername(String name);
}
