package com.example.demo.netty.entity;

import org.msgpack.annotation.Message;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * 用户实体
 */
@Message
public class User implements Serializable {
    /**
     * 序列化标识
     */
    private static final long serialVersionUID = -5462474276911290451L;
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 分数
     */
    private double source;
    /**
     * 领导
     */
    private User leader;

    public byte[] codeC() {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        byte[] bytes = this.name.getBytes();
        allocate.putInt(bytes.length);
        allocate.put(bytes);
        allocate.putInt(this.id);
        allocate.flip();
        bytes = null;
        byte[] res = new byte[allocate.remaining()];
        allocate.get(res);
        return res;
    }

    public byte[] codeC(ByteBuffer buffer) {
        buffer.clear();
        byte[] bytes = this.name.getBytes();
        buffer.putInt(bytes.length);
        buffer.put(bytes);
        buffer.putInt(this.id);
        buffer.flip();
        bytes = null;
        byte[] res = new byte[buffer.remaining()];
        buffer.get(res);
        return res;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSource() {
        return source;
    }

    public void setSource(double source) {
        this.source = source;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Double.compare(user.source, source) == 0 &&
                Objects.equals(name, user.name) &&
                Objects.equals(leader, user.leader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, source, leader);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source=" + source +
                ", leader=" + leader +
                '}';
    }
}