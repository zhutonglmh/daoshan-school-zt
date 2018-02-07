package com.daoshan.school.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义校验器   验证是否为正整数
 * 
 * @author 朱同(雏鹰订餐系统组) 2017/12/15
 *
 */
public class CheckIntegerValidatorImpl
        implements
            ConstraintValidator<CheckIntegerValidator, Integer> {

    private int len;

    /**
     * 自定义校验器（验证字符串）
     * 
     * @author 朱同 2017/12/15
     * 
     *         初始参数,获取注解中length的值
     */
    public void initialize(CheckIntegerValidator arg0) {
        this.len = arg0.length();
    }

    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        if (number != null) {

            String rex = "^[0-9]+[0-9]*$";
            String numberStr = number.toString();
            Pattern p = Pattern.compile(rex);
            Matcher m = p.matcher(numberStr);
            if (m.find()) {
                return true;
            } else {
                constraintValidatorContext.disableDefaultConstraintViolation();// 禁用默认的message的值
                // 重新添加错误提示语句
                constraintValidatorContext.buildConstraintViolationWithTemplate("不可包含非法字符！！")
                        .addConstraintViolation();
                return false;
            }
        } else {
            return true;
        }
    }

}
