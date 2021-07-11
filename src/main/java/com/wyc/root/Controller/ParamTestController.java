package com.wyc.root.Controller;

import com.wyc.root.pojo.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParamTestController
{

    @PostMapping("/saveuser")
    public Person saveuser(Person person)
    {
        return person;
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("Sec-Fetch-Site") String sec,
                                     @RequestHeader Map<String,String> headerMap,
                                     @RequestParam("age")Integer age,
                                     @RequestParam("inters")List<String> inters,
                                     @RequestParam Map<String,String> paramMap,
                                     @CookieValue Cookie cookie)
    {
        Map<String,Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("sec",sec);
//        map.put("header",headerMap);
        map.put("age",age);
        map.put("inters",inters);
        map.put("paramMap",paramMap);
        map.put("cookie",cookie);


        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content)
    {
        Map<String,Object> map =new HashMap<>();
        map.put("content",content);
        return map;
    }
}
