package com.example.demo;

public class TestMy {
    /**
     * 关于Static{}块的解释：
     * 只是在执行main之前执行的一些语句而已，并不是说里面的变量就是
     * static的，没什么特别的。
     * 临时变量只在static这个大括号中有用。
     **/
    static {
        int x = 8;
        System.out.println("我是static，我有一个变量x=" + x);
    }

    static int x;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(x);
    }
}
