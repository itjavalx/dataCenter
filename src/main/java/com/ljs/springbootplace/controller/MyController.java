package com.ljs.springbootplace.controller;

import com.ljs.springbootplace.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/my")
public class MyController {

    @Resource
    private MyService myService;


    public Object test(){
        return myService.test();
    }
}
