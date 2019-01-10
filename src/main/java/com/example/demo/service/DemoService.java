package com.example.demo.service;


import com.example.demo.beans.Demo;
import com.example.demo.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public Demo find(long id) {
        return demoMapper.getOne(id);
    }
    public List<Demo> findAll() { return demoMapper.getAll(); }
}
