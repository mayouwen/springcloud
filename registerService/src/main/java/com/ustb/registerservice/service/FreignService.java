package com.ustb.registerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName：FreignService
 * Description:
 * author: mayouwen
 * date: 2018/11/13
 */
@FeignClient(name = "foreignService")
public interface FreignService {
    @RequestMapping("/home")
    String home();
}
