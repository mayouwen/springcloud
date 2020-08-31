package com.ustb.registerservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ustb.registerservice.dto.User;
import com.ustb.registerservice.service.FreignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName：TestController
 * Description:
 * author: mayouwen
 * date: 2018/11/13
 */
@RestController
@Slf4j
public class TestController {
    @Resource
    private FreignService freignService;

    @GetMapping("/test/home")
    @HystrixCommand(fallbackMethod = "exceptions")
    public String testHome() {
      /*  int a = 0, c = 1;
        int d = c/a;  // 抛出异常触发*/
        log.info("调用foreignservice服务");
        return freignService.home();
    }

    /**
     * 断路回调方法
     */
    public String exceptions(){
        return "exception---registerService";
    }

    @PostMapping("/test")
    public void test(@RequestBody User user){}
}
