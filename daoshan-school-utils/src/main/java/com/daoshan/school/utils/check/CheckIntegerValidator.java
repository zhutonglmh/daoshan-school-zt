package com.daoshan.school.utils.check;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * 自定义校验器   验证是否为正整数
 * 
 * @author 朱同(雏鹰订餐系统组) 2017/12/15
 *
 */
@Constraint(validatedBy = CheckIntegerValidatorImpl.class)
// 具体的实现
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface CheckIntegerValidator {
    
    String message() default "{输入了非法数据}"; // 提示信息,可以写死,可以填写国际化的key

    int length() default 5;

    // 下面这两个属性必须添加
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
