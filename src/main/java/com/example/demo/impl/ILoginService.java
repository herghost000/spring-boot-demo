package com.example.demo.impl;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.Map;

public interface ILoginService {
    User addUser(Map<String, Object> map);

    Role addRole(Map<String, Object> map);

    User findByName(String name);
}
