package com.ljs.springbootplace.controller;

import com.ljs.springbootplace.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class RequestController {

    public static void main(String[] args) {
        for (int i = 1; i <= 24; i++) {
            System.out.print(",'" + i + "'");
        }
    }

    @PostMapping(value = "/postR/{type}/user",consumes = "application/json")
    public Object postRequest(@PathVariable String type,  User user) {
        System.out.println(user);
        System.out.println("{type}:" + type);
        return user;
    }


    @GetMapping("/getR")
    public String getRequest(@RequestParam("type") String type) {
        System.out.println(type);
        return "+" + type + "+";
    }

}