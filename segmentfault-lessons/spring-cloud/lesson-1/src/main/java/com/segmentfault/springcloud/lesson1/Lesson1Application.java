package com.segmentfault.springcloud.lesson1;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson1Application {
    
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Lesson1Application.class);
        
        // 取消 Banner 打印
        springApplication.setBannerMode(Banner.Mode.OFF);
        
        // 设置成非 web 程序
        springApplication.setWebEnvironment(true);
        
        springApplication.run(args);
    }
}
