package com.example.demo.impl;

import com.example.demo.entity.SysRole;
import com.example.demo.entity.User;

import java.util.Map;

public interface ILoginService {
    User findByName(String name);
    User findUserByUsername(String name);
    User addUser(Map map);
}
