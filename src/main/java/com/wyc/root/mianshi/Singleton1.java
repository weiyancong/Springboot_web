package com.wyc.root.mianshi;

/**
 * 饿汉式：直接创建实例对象，不管你是否需要，这个对象都会创建
 */
public class Singleton1
{
    //1、构造器私有化
    private  Singleton1()
    {

    }
    //2、创建静态变量（方便类名+属性名直接获取）
    //3、对外提供这个实例 + public
    //4、强调这是一个单例 + final（不可修改）
    public static final Singleton1 INSTANCE = new Singleton1();
}
