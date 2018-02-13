package com.daoshan.school.aop.AspectControl;

import com.daoshan.school.aop.AspectMethod.AopDemo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessControlAspect {

    @Autowired
    private AopDemo aopDemo;

    //切入点
    @Pointcut("@annotation(com.daoshan.school.aop.annotation.AccessControl)")
    public  void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        aopDemo.aopDemo();
    }
}
