package com.example.demo.controller;

import com.example.demo.beans.Demo;
import com.example.demo.service.DemoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/testfind")
    @Cacheable(value = "demo", key="'all'")
    public List<Demo> find() {
        PageHelper.startPage(1, 2);
        return demoService.findAll();
    }

}
