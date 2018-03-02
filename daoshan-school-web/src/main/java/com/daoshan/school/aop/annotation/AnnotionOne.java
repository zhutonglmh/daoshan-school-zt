package com.daoshan.school.aop.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD})//用于设定注解使用范围
@Retention(RetentionPolicy.RUNTIME) //Reteniton的作用是定义被它所注解的注解保留多久，一共有三种策略
/* SOURCE 被编译器忽略
   CLASS  注解将会被保留在Class文件中，但在运行时并不会被VM保留。这是默认行为，所有没有用Retention注解的注解，都会采用这种策略。
   RUNTIME  保留至运行时。所以我们可以通过反射去获取注解信息。*/
@Documented
//cumented 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的. 但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中.
public @interface AnnotionOne {
}
