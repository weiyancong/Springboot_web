package com.wyc.root.Controller;

import lombok.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HellowControl
{

    @RequestMapping("/aa.jpg")
    public String hello()
    {
        return "hellow";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser()
    {
        return "Get用户";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String postUser()
    {
        return "POST用户";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser()
    {
        return "delete用户";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser()
    {
        return "put用户";
    }
}
