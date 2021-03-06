package com.example.demo.controller;

import com.example.demo.beans.Greeting;
import com.example.demo.impl.HerGhost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Resource
    private HerGhost herghost;
    @Value("${com.example.demo.title}")
    private String title;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/greeting/{message}")
    public String msg(@PathVariable("message") String msg) {
        return "echo" + msg;
    }

    @RequestMapping("/greeting/ip")
    public String ip(HttpServletRequest request, HttpServletResponse response) {
        return "your ip:" + request.getRemoteAddr();
    }

    @RequestMapping("/greeting/testAutoAndResource")
    public String testAutoAndResource() {
        herghost.say();
        return "666";
    }

    @RequestMapping("/greeting/read/application.properties")
    public String prop() {
        return "what???" + title;
    }

}
