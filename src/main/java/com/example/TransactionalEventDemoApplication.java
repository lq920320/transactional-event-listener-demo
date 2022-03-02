package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zetu
 * @date 2022/2/11
 */
@SpringBootApplication
@MapperScan("com.example.*.mappers")
public class TransactionalEventDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalEventDemoApplication.class, args);
    }
}
