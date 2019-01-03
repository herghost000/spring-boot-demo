package com.example.demo.mapper;

import com.example.demo.Demo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Configurable;

public interface DemoMapper {

    @Select("select * from demo where id = #{id}")
    public Demo findById(long id);

}
