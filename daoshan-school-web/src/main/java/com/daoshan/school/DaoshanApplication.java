package com.daoshan.school;

import com.cohen.redis.RedisCacheAutoConfiguration;
import com.cohen.redis.assembly.cache.RedisCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportAutoConfiguration(RedisCacheAutoConfiguration.class)
@ServletComponentScan
@ComponentScan({"com.daoshan","com.cohen.redis","com.cohen.redis.assembly"})
@MapperScan({"com.daoshan.dao","com.cohen.redis","com.cohen.redis.assembly"})
@EnableTransactionManagement
public class DaoshanApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DaoshanApplication.class, args);
		System.out.println(run.getBean(RedisCache.class));
		System.out.println("启动完成");
	}
}
