package com.ljs.springbootplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication//开启文件和配置扫描
@EnableCaching //开启缓存支持
public class SpringbootplaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootplaceApplication.class, args);
    }

}
