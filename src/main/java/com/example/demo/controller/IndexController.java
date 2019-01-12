package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public List<User> index() {
        Pageable p = PageRequest.of(0,2);
        return userRepository.findUserByName("herghost");
//        return userRepository.findAll(p);
    }

    @RequestMapping("/delete")
    public void delete() {
        userRepository.deleteById(1L);
    }
}
