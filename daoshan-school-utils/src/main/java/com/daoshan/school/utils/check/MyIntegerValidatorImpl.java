package com.daoshan.school.utils.check;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义校验器   验证是否全是由字母组成
 * 
 * @author 朱同(雏鹰订餐系统组) 2017/12/15
 *
 */
public class MyIntegerValidatorImpl implements ConstraintValidator<MyIntegerValidator, String> {  
    
    private int len;
    
    /** 
     * 自定义校验器（验证字符串）
     * 
     * @author 朱同 2017/12/15
     * 
     * 初始参数,获取注解中length的值 
     */  
    public void initialize(MyIntegerValidator arg0) {  
        this.len = arg0.length();  
    }  
  
    @Override  
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {  
        if(str != null && !"".equals(str)){  
            String rex = "^[A-Za-z]+$";
            Pattern p = Pattern.compile(rex);
            Matcher m = p.matcher(str);
            if(m.find()){  
                return true; 
                }
            else{
                constraintValidatorContext.disableDefaultConstraintViolation();//禁用默认的message的值  
                //重新添加错误提示语句  
                constraintValidatorContext  
                .buildConstraintViolationWithTemplate("输入了不合法数据！！").addConstraintViolation();
                return false;
            }
        }else{  
            return true;  
        }  
    }  
    
}  