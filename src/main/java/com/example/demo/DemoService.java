package com.example.demo;


import com.example.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public Demo find(long id) {
        return demoMapper.findById(id);
    }
}
