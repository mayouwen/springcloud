package com.ustb.foreignservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：HelloController
 * Description:
 * author: mayouwen
 * date: 2018/11/13
 */
@RestController
public class HelloController {
    @RequestMapping("/home")
    public String home() {
        return "hello i am foreignservice";
    }
}
