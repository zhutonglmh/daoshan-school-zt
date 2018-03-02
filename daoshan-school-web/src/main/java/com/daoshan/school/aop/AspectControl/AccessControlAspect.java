package com.daoshan.school.aop.AspectControl;

import com.daoshan.bean.dsxh.entity.DsxhUser;
import com.daoshan.school.aop.AspectMethod.AopDemo;
import com.daoshan.school.utils.messagebody.MessageBody;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 切面  使用注解标识拦截方法
 * Created By java-zt On 2018-02-13
 */
@Aspect //标注切面
@Component //
public class AccessControlAspect {

    @Autowired
    private AopDemo aopDemo;

    //切入点 匹配  --------------------------------------------------------------------------------------------------
    @Pointcut("@annotation(com.daoshan.school.aop.annotation.AccessControl)")
    public  void annotationPointCut() {
    }

    @Before("annotationPointCut()")  //在这个切入点执行之前执行
    public void before(JoinPoint joinPoint){
        aopDemo.aopDemo();
    }

    //匹配该类中的所哟方法--------------------------------------------------------------------------------------------
    @Pointcut("within(com.daoshan.school.controller.UserLoginController)")
    public void demo(){
    }

    //匹配com.daoshan.school.controller包 及 子包下所有类的方法
    @Pointcut("within(com.daoshan.school.controller..*)")
    public void demo2(){
    }

    //匹配对象-----------------------------------------------------------------------------------------------------

    //匹配AOP对象的目标为指定类型的方法，及UserLoginController的aop代理对象的方法
    @Pointcut("this(com.daoshan.school.controller.UserLoginController)")
    public void demo4(){}

    //匹配实现了DsxhUserService接口的目标对象（而不是aop代理后的对象的所有方法
    @Pointcut("target(com.daoshan.service.dsxh.DsxhUserService)")
    public void demo5(){}

    //匹配所有以Service结尾的bean里头的所有方法
    @Pointcut("bean(*Service)")
    public void demo6(){}

    //参数匹配--------------------------------------------------------------------------------
    //匹配任何以find开头而且只有一个Long参数的方法
    @Pointcut("execution(* *..find*(Long))")
    public void demo7(){}

    //匹配任何只有一个Long参数的方法
    @Pointcut("args(Long)")
    public void demo8(){}

    //匹配任何以find开头的而且第一个参数为Long型的方法
    @Pointcut("execution(* *..find*(Long,..))")
    public void demo9(){}

    //匹配第一个参数为Long型的方法
    @Pointcut("args(Long,..)")
    public void demo10(){}

    //匹配第一个参数为Long型的方法 且在UserLoginController类中
    @Pointcut("args(Long,..) && within(com.daoshan.school.controller.UserLoginController)")
    public void demo11(){}


    //匹配注解-------------------------------------------------------------------------------------
    //该方法匹配标注有AnnotionOne注解的方法
    @Pointcut("@annotation(com.daoshan.school.aop.annotation.AnnotionOne)")
    public void demo12(){}

    //匹配标注有Beat的类底下的方法，要求的annotation的RetentionPolicy级别为RUNTIME
    @Pointcut("@within(com.daoshan.school.aop.annotation.AnnotionOne)")
    public void demo13(){}

    //匹配标注有Repository的类底线的方法，要求的annotation的RetentionPolicy级别为RUNTIME
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void demo14(){}

    //匹配传入的参数类标注有Repository注解的方法
    @Pointcut("@args(org.springframework.stereotype.Repository)")
    public void demo15(){}

    //execution 匹配
    /*
        execution() {
                        modifier-pattern? 修饰符pattern
                       + ret-type-pattern  返回值pattern
                       + declaring-type-pattern? 描述包名
                       + name-pattern(param-pattern) 描述方法名 （描述参数名）
                       + throws-pattern    抛出异常pattern
                    }
     */

    @Pointcut("execution(public com.daoshan.school.utils.messagebody.MessageBody isUserLogin())")
    public void demo16(){}

    @Pointcut("execution(public com.daoshan.school.utils.messagebody.MessageBody deleteUser(..))")
    public void demo25(){}
    // 五种advice 注解
    /*
        @Before          前置通知，方法执行之前
        @After(finally)  后置通知，方法执行完之后
        @AfterReturning  返回通知，成功执行之后
        @AfterThrowing   异常通知，抛出异常之后
        @Around          环绕通知，执行前后都通知
     */
    @Before("demo16()")  //方法执行之前
    public void demo17(){
        System.out.println("方法执行之前 execution执行成功！！");
    }
    @After("demo16()")  //方法执行之后
    public void demo18(){
        System.out.println("方法执行之后 execution执行成功！！");
    }
    @AfterReturning("demo16()")  //方法成功执行之后
    public void demo19(){
        System.out.println("方法成功执行之后 execution执行成功！！");
    }
    @AfterThrowing("demo16()")  //方法抛出异常之后
    public void demo20(){
        System.out.println("方法抛出异常之后 execution执行成功！！");
    }
    @Around("demo16()")  //环绕通知
    public void demo21(){
        System.out.println("环绕通知 execution执行成功！！");
    }
    //携带参数---------获取参数或者返回值----------------------------------------------------------------------

    @AfterReturning(value = "demo25()",returning = "result")  //方法执行之后  获取返回值
    public void demo26(MessageBody  result){
        System.out.println(result);
    }

   /* @Around("demo25()")
    public void demo26(ProceedingJoinPoint joinPoint){
            Object result = null;
        try{
            result = joinPoint.proceed(joinPoint.getArgs());//getArgs()获取连接点方法运行时的入参列表；通过反射执行目标对象连接点处的方法，joinPoint.proceed(Object ss)不过使用新的入参替换原来的入参。
            System.out.println(result);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }*/
    @Before("demo25() && args(dsxhUser)")
    public void demo27(DsxhUser dsxhUser){
        System.out.println("获取参数 +"+dsxhUser);
    }
}
