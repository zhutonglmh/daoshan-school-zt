package com.daoshan.school;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常类
 * @author 张崇宝
 *
 */
@ControllerAdvice
public class MycontrollerHandleException {
  
    private static final Logger log = LoggerFactory.getLogger(MycontrollerHandleException.class); 
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String errorHandle(Exception e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "-1");
        map.put("message", "请求有误");
        map.put("getMessage", e.getMessage());
        map.put("getClass", e.getClass());
        map.put("getCause", e.getCause());
        map.put("getLocalizedMessage", e.getLocalizedMessage());
        //map.put("getStackTrace", e.getStackTrace());
        map.put("getSuppressed", e.getSuppressed());
        String result = JSON.toJSONString(map);
        log.error("异常名称："+e.getClass()+"\n错误位置："+e.getStackTrace()[0].getClassName()+"-----"+e.getStackTrace()[0].getFileName()+"-----"+e.getStackTrace()[0].getMethodName()
            +"-----"+e.getStackTrace()[0].getLineNumber());
        return result;
    }
}
