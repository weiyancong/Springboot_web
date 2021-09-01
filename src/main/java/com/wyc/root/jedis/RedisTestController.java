package com.wyc.root.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController
{
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String getName()
    {
        //赋值
        redisTemplate.opsForValue().set("name","weiyancong");
        //从Redis中取值
        String name = (String)redisTemplate.opsForValue().get("name");
        return name;
    }
}
