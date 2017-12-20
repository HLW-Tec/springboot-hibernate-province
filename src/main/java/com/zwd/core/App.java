package com.zwd.core;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = "com.zwd.core")
@EnableJpaRepositories("com.zwd.core.mappers")
@EntityScan(basePackages = "com.zwd.core.entity")
@SpringBootApplication
@EnableScheduling
public class App extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
