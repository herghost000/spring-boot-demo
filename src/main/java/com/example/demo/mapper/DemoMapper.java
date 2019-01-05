package com.example.demo.mapper;

import com.example.demo.controller.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper {

    @Select("select * from demo where id = #{id}")
    public Demo findById(long id);

    @Select("select * from demo")
    public List<Demo> findAll();

    @Insert("insert into demo(name) values(#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public void save(Demo demo);

}
