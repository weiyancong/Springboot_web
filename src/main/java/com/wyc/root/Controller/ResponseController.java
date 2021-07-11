package com.wyc.root.Controller;

import com.wyc.root.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseController
{
    @ResponseBody
    @GetMapping("/getperson")
    public Person getPerson()
    {
        Person person = new Person();
        person.setUserName("zhangsan2");
        person.setAge(19);
        person.setBirth(new Date());
        return person;
    }
}
