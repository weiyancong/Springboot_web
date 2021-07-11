package com.wyc.root.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController
{
    @GetMapping("/atguigu")
    public String success(Model model)
    {
        model.addAttribute("msg","南山必胜客！");
        model.addAttribute("link","https://www.baidu.com");
        return "success";
    }
}
