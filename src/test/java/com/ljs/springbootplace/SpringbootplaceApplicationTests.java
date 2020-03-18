package com.ljs.springbootplace;

import com.ljs.springbootplace.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootplaceApplication.class)
public class SpringbootplaceApplicationTests {

    @Autowired
    private MyService myService;

    @Test
    public void contextLoads() {
        String userNameById = myService.getUserNameById(1);
        System.out.println(userNameById);
    }


    @Test
    public void removeRedis() {
        System.out.println(myService.updateRedis(1));
    }


    @Test
    public void testAop() {
        String userNameById = myService.getUserNameById_testAspect(1);//测试aop
        System.out.println(userNameById);
    }

}
