package com.daoshan.school.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义校验器   验证是否含有非法字符
 * 
 * @author 朱同(雏鹰订餐系统组) 2017/12/15
 *
 */
public class CheckCharacterValidatorImpl implements ConstraintValidator<CheckCharacterValidator, String> {  
    
    private int len;
    
    /** 
     * 自定义校验器（验证字符串）
     * 
     * @author 朱同 2017/12/15
     * 
     * 初始参数,获取注解中length的值 
     */  
    public void initialize(CheckCharacterValidator arg0) {  
        this.len = arg0.length();  
    }  
  
    @Override  
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {  
        if(str != null && !"".equals(str)){  
            
            String rex = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
            Pattern p = Pattern.compile(rex);
            Matcher m = p.matcher(str);
            if(m.find()){  
                constraintValidatorContext.disableDefaultConstraintViolation();//禁用默认的message的值  
                //重新添加错误提示语句  
                constraintValidatorContext  
                .buildConstraintViolationWithTemplate("不可包含非法字符！！").addConstraintViolation();
                return false; 
                }
            else{
                return true;
            }
        }else{  
            return true;  
        }  
    }  
    
}  