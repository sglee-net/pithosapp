package org.chronotics.db.mybatis.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"org.chronotics.db.mybatis",
		"org.chronotics.db.mybatis.app",
		"org.chronotics.db.mybatis.app.controller",
		"org.chronotics.db.mybatis.app.mapper",
		"org.chronotics.db.mybatis.app.service"})
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Application.class,args);
	}
}