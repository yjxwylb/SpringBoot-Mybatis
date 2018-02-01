package com.learn.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author XYJ
 * @类描述:
 * @Date:Created in 2018/1/15 9:37
 * @Version:
 */
@SpringBootApplication
@MapperScan("com.learn.*.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
