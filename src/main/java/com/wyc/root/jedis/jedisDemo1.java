package com.wyc.root.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class jedisDemo1
{
    public static void main(String[] args)
    {
        //创建jedis对象
        Jedis jedis = new Jedis("10.211.55.3", 6379);
        System.out.println(jedis.ping());
        jedis.close();
    }

    /**
     * String类型
     */
    @Test
    public void demo1()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("10.211.55.3", 6379);
        //赋值
        jedis.set("name","weiyancong");
        //批量赋值
        jedis.mset("k1","v1","k2","v2");
        //批量取值
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println("redis_key："+key);
        }
    }

    /**
     * List类型
     */
    @Test
    public void demo2()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("10.211.55.3", 6379);

        //赋值
        jedis.lpush("key1","liuyang","wyc","qgs");
        List<String> key1 = jedis.lrange("key1", 0, -1);
        System.out.println(key1);
    }

    /**
     * Set数据类型
     */
    @Test
    public void demo3()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("10.211.55.3", 6379);

        //赋值
        jedis.sadd("set_key","val_1","val_2","val_3");

        //取值
        Set<String> smembers = jedis.smembers("set_key");

        System.out.println(smembers);
    }

    /**
     * Hash数据类型
     */
    @Test
    public void demo4()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("10.211.55.3", 6379);

        //赋值
        jedis.hset("hash_user","name","zhangsan");

        //取值
        String hget = jedis.hget("hash_user", "name");

        System.out.println(hget);
    }

    /**
     * ZSet数据类型
     */
    @Test
    public void demo5()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("10.211.55.3", 6379);

        //赋值
        jedis.zadd("zset_user",50,"lisi");
        jedis.zadd("zset_user",10,"zhangsan");
        jedis.zadd("zset_user",101,"name101");

        //取值
        Set<String> zset_user = jedis.zrange("zset_user", 0, -1);
        System.out.println(zset_user);

    }
}
