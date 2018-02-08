package com.daoshan.school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@ServletComponentScan
@ComponentScan("com.daoshan")
@MapperScan("com.daoshan.dao")
@EnableTransactionManagement
public class DaoshanSchoolWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaoshanSchoolWebApplication.class, args);
	}
}
