package com.example.demo.mapper;

import com.example.demo.beans.Demo;

import java.util.List;

public interface DemoMapper {

    List<Demo> getAll();

    Demo getOne(Long id);

    void insert(Demo user);

    void update(Demo user);

    void delete(Long id);

}
