package com.wyc.root.mianshi;

/**
 * 懒汉式：
 *  1、构造器私有化
 *  2、创建一个静态变量保存唯一实例
 *  3、提供一个静态方法获取这个实例对象
 *
 */
public class Singleton4
{
    private static Singleton4 instance;
    private Singleton4()
    {

    }
    public static Singleton4 getInstance()
    {
        if(instance == null)
        {
            synchronized(Singleton4.class)
            {
                if(instance == null)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
