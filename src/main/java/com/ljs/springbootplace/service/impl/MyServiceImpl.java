package com.ljs.springbootplace.service.impl;

import com.ljs.springbootplace.mapper.MyMapper;
import com.ljs.springbootplace.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private MyMapper myMapper;

    @Override
    public String test() {
        return "test";
    }


    @Cacheable(value = "getUserNameById")
    @Override
    public String getUserNameById(Integer id) {
        System.err.println("数据库");
        return myMapper.getUserNameById(id);
    }



    @CacheEvict(value = "getUserNameById", allEntries = true)
    @Override
    public String updateRedis(Integer id) {
        return "清空redis";
    }

    @Override
    public String getUserNameById_testAspect(Integer id){
        return myMapper.getUserNameById(id);
    }
}