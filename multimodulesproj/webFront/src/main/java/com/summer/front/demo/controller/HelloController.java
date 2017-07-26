package com.summer.front.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangxz on 2017/7/12.
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/printHello")
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("message1", "hello this is printHello function.");
        return "hello";
    }
}
