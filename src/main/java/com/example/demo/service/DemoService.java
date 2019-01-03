package com.example.demo.service;


import com.example.demo.Demo;
import com.example.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public Demo find(long id) {
        return demoMapper.findById(id);
    }
    public List<Demo> findAll() { return demoMapper.findAll(); }
}
