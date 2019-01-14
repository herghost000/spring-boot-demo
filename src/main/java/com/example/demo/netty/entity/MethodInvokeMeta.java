package com.example.demo.netty.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class MethodInvokeMeta implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 接口
     */
    private Class<?> interfaceClass;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数
     */
    private Object[] args;
    /**
     * 返回值类型
     */
    private Class<?> returnType;
    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    public MethodInvokeMeta() {
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Class getReturnType() {
        return returnType;
    }

    public void setReturnType(Class returnType) {
        this.returnType = returnType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodInvokeMeta that = (MethodInvokeMeta) o;
        return Objects.equals(interfaceClass, that.interfaceClass) &&
                Objects.equals(methodName, that.methodName) &&
                Arrays.equals(args, that.args) &&
                Objects.equals(returnType, that.returnType) &&
                Arrays.equals(parameterTypes, that.parameterTypes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(interfaceClass, methodName, returnType);
        result = 31 * result + Arrays.hashCode(args);
        result = 31 * result + Arrays.hashCode(parameterTypes);
        return result;
    }

    @Override
    public String toString() {
        return "MethodInvokeMeta{" +
                "interfaceClass=" + interfaceClass +
                ", methodName='" + methodName + '\'' +
                ", args=" + Arrays.toString(args) +
                ", returnType=" + returnType +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}