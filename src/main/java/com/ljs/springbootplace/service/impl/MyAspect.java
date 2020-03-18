package com.ljs.springbootplace.service.impl;

import com.ljs.springbootplace.service.MyService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import java.util.Properties;

@Aspect
@Component
public class MyAspect {

    private Properties properties = null;

    @Around("execution(* com.ljs.springbootplace.service.impl.MyServiceImpl.getUserNameById_testAspect(..))")
    public Object roundAsp(ProceedingJoinPoint pj) {
        System.out.println("前");

        Object proceed = null;
        try {
            MethodSignature signature = (MethodSignature) pj.getSignature();
            String name = signature.getName();
            Method method = signature.getMethod();
            String methodName = method.getName();
            System.out.println(methodName);
            proceed = pj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("后");

        return proceed;
    }


    private Properties getProperties() {
        if (properties == null) {
            InputStream in = null;
            try {
                in = MyAspect.class.getClassLoader().getResourceAsStream("dictionary.properties");
                Properties p = new Properties();
                p.load(in);
                return p;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert in != null;
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
