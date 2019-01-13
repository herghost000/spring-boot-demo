package com.example.demo.service;

import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysRole;
import com.example.demo.entity.User;
import com.example.demo.impl.ILoginService;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private UserRepository userRepository;

    //查询用户通过用户名
    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findUserByUsername(String name) {
        return userRepository.findUserByUsername(name);
    }

    @Override
    public User addUser(Map map) {
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        ByteSource salt = ByteSource.Util.bytes(username);
        String newPassword = new SimpleHash("MD5", password, salt, 1024).toHex();
        User u = new User();
        u.setUsername("admin");
        u.setName("herghost");
        u.setPassword(newPassword);
        u.setState(new Byte("1"));
        u.setSalt(salt.toString());
        userRepository.save(u);
        return u;
    }

}
