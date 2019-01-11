package com.example.demo.controller;

import com.example.demo.beans.Greeting;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public Page<User> index() {
        Pageable p = PageRequest.of(0,2);
        return userRepository.findAll(p);
    }
}
