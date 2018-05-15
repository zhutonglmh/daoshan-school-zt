package com.daoshan.school.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * 注册拦截器
 *
 */
@Configuration
/*@EnableWebMvc*/
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig(){
        super();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**").excludePathPatterns("/dsxh/user/**");
        super.addInterceptors(registry);
    }
}