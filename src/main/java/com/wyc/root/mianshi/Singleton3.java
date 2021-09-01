package com.wyc.root.mianshi;

/**
 * 静态代码块的方式
 */
public class Singleton3
{
    public static final Singleton3 INSTACE;

    static {
        INSTACE = new Singleton3();
    }

    private Singleton3()
    {

    }
}
