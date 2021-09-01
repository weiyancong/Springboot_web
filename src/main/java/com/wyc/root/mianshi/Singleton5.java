package com.wyc.root.mianshi;

/**
 * 懒汉式：内部静态类
 *   在内部类被加载和初始化时，才创建INSTRACE实例对象
 *   静态内部类不会随着外部类的加载和初始化而初始化，它是要单独加载和初始化的，
 *   因为是在内部类加载和初始时创建的，所以是线程安全的
 */
public class Singleton5
{
    //私有化构造器
    private Singleton5()
    {

    }
    //创建内部静态类，获取对象
    private static class inner
    {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    //调用内部类
    public static  Singleton5 getInstace()
    {
        return inner.INSTANCE;
    }
}
