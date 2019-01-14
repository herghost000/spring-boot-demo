package com.example.demo.netty.entity;

import java.io.Serializable;

public class NullWritable implements Serializable {
    /**
     * 序列化标识
     */
    private static final long serialVersionUID = 1L;
    /**
     * 单例
     */
    private static NullWritable instance = new NullWritable();

    /**
     * 私有构造器
     */
    private NullWritable() {
    }

    /**
     * 返回代表Null的对象
     *
     * @return {@link NullWritable} 当方法返回值为void时或返回值为null时返回此对象
     */
    public static NullWritable nullWritable() {
        return instance;
    }
}