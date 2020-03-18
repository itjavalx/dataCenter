package com.ljs.springbootplace.service;

import org.springframework.cache.annotation.CacheEvict;


public interface MyService {
    String test();

    String getUserNameById(Integer id);


    String updateRedis(Integer id);

    String getUserNameById_testAspect(Integer id);

}
