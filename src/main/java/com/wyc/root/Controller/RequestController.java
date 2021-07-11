package com.wyc.root.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController
{
    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request)
    {
        request.setAttribute("name","zangsan");
        request.setAttribute("status",200);
        return "forward:success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(HttpServletRequest request,
                       @RequestAttribute("name") String name,
                       @RequestAttribute("status") Integer status)
    {
        String name02 = request.getAttribute("name").toString();
        Map<String,Object> map = new HashMap<>();
        map.put("name01",name);
        map.put("name02",name02);
        map.put("status",status);
        return map;
    }

}
