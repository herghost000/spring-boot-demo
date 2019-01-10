package com.example.demo.service;

import com.example.demo.interfaces.HerGhost;
import org.springframework.stereotype.Service;

@Service
public class HerGhostImpl implements HerGhost {

    @Override
    public void say() {
        System.out.println("hello herghost");
    }
}
