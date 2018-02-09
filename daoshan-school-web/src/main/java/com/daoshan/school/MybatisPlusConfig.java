package com.daoshan.school;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {


        @Bean
        public PaginationInterceptor paginationInterceptor(){
            PaginationInterceptor page = new PaginationInterceptor();
            page.setDialectType("mysql");
            return page;
        }


}
