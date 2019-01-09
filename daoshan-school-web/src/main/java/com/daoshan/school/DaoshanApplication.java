package com.daoshan.school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.daoshan.dao")
@ComponentScan("com.daoshan")
@EnableTransactionManagement
public class DaoshanApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DaoshanApplication.class, args);
		System.out.println("启动完成");
	}
}
