package com.wyc.root.jedis;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
*  验证码校验
*/
public class PhoneCode
{
    public static void main(String[] args)
    {

        //判断手机号是否3次验证
        verifyCode("17770592006");
        //校验验证码
//        getRedisCode("17770592006","430400");
    }

    @Test
    public void demo()
    {
        //校验验证码
        getRedisCode("17770592006","776233");
    }

    /**
     * 3、校验验证码
     */
    public static void getRedisCode(String phone,String inCode)
    {
        //获取redis中的验证码
        Jedis jedis = new Jedis("10.211.55.3", 6379);
        String codeKey = "key"+phone+":code";
        String redisCode = jedis.get(codeKey);
        //判断输入的验证码是否与redis验证码一致
        if(redisCode.equals(inCode))
        {
            System.out.println("验证成功！");
        }
        else
        {
            System.out.println("验证失败！");
        }
    }

    /**
     * 2、每个手机每天只能发送三次，验证码放到redis中，设置过期时间
     * @param phone
     */
    public static void verifyCode(String phone)
    {
        //创建jedis对象
        Jedis jedis = new Jedis("10.211.55.3", 6379);

        //拼接key
        //手机发送次数key
        String countKey = "key"+phone+":count";
        //验证码的key
        String codeKey = "key"+phone+":code";

        //获取当前手机验证次数
        String phoneCount = jedis.get(countKey);
        if(phoneCount == null)
        {
            //手机次数key设为24小时后过期
            jedis.setex(countKey,24*60*60,"1");
        }
        else if(Integer.parseInt(phoneCount) <= 2)
        {
            jedis.incr(countKey);//次数自动加1
        }
        else if(Integer.parseInt(phoneCount) > 2)
        {
            System.out.println("24小时内只允许申请3次验证码！");
        }
        //验证码存入Redis
        String code = getCode();
        jedis.setex(codeKey,120,code);
        //关闭连接
        jedis.close();
    }

    /**
     * 1、生成6位随机验证码
     * @return
     */
    public static String getCode()
    {
        Random random = new Random();
        String randomStr = "";
        for(int i=0;i<6;i++)
        {
            randomStr +=  random.nextInt(10);
        }åå
       return randomStr;
    }
}
