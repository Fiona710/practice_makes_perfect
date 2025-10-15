package com.practice.pmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 * 
 * @author zhangyaqi
 * @date 2025-10-15
 */
@SpringBootApplication
public class PracticeMakesPerfectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeMakesPerfectApplication.class, args);
        System.out.println("====================================");
        System.out.println("Practice Makes Perfect 应用启动成功！");
        System.out.println("访问地址: http://localhost:8080");
        System.out.println("====================================");
    }

}

